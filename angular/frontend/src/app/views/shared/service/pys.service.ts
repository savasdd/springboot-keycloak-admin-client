import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import request from "axios";
import { Router } from '@angular/router';
import { PYS_URL } from "../service/pys.url";
import { CustomCombo } from "../model/CustomCombo";
import { ToastType } from "../model/ToastType";
import { Cookie } from 'ng2-cookies/ng2-cookies';
import { ToastrService } from 'ngx-toastr';


@Injectable({
  providedIn: 'root'
})
export class PysService implements OnInit {
  header: HttpHeaders;

  constructor(private router: Router, private http: HttpClient, public toastr: ToastrService) { }

  ngOnInit(): void {
  }


  loginApi(username: string, password: string): void {
    const dto = {
      "username": username,
      "password": btoa(password)
    }

    let resp = request({
      url: PYS_URL.GET_TOKEN,
      method: 'POST',
      data: dto,
    }).then(async function (response) {

      if (response.data.token) {
        localStorage.setItem("tkn", response.data.token);
        localStorage.setItem("rfrsh", response.data.refreshToken);
        Cookie.set('tkn', response.data.token);
        return true;
      } else {
        console.log("Kullanıcı bulunamadı!'");
        return false;
      }

    }).catch(function (error) {
      console.log("hata2 " + error);
      return false;
    });

    resp.then(val => {
      if (val)
        this.router.navigate(['/dashboard']);
      else
        this.showToast(ToastType.warning, "Uyarı", "Kullanıcı bulunamadı!");
    });
  }

  logoutApi(): void {
    localStorage.removeItem("tkn");
    Cookie.delete('tkn');
    this.router.navigate(['/login']);
    console.log("Logout!")
  }


  getHeader(): HttpHeaders {
    this.header = new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8',
      'Authorization': `Bearer ${Cookie.get('tkn')}`,
    })
    return this.header;
  }


  getList(url: string, params: HttpParams): Observable<Object[]> {
    return this.http.get<Object[]>(url, { headers: this.getHeader(), params });
  }

  getListBody(url: string, dto: object): Observable<Object[]> {
    return this.http.post<Object[]>(url, dto, { headers: this.getHeader() });
  }

  getBirimKurulus(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim ? dt.tanim + ' (' + dt.kisaTanim + ')' : '',
          user.value = dt.bagliBirim + "," + dt.isYeriId + "," + dt.kurum.kurumId
        dataList.push(user);
      });
    });

    return dataList;
  };

  getKurum(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim ? dt.tanim + ' (' + dt.kisaTanim + ')' : '',
          user.value = dt.kurumId ? dt.kurumId : ''
        dataList.push(user);
      });
    });

    return dataList;
  };

  getIsYeri(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim ? dt.tanim : '',
          user.value = dt.isYeriId ? dt.isYeriId : ''
        dataList.push(user);
      });
    });

    return dataList;
  };

  getBirim(url: string, param: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
      params: { 'param': param !== undefined ? param : 'null' }
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim ? dt.tanim : '',
          user.value = dt.birimId ? dt.birimId.birimId : ''
        dataList.push(user);
      });
    });

    return dataList;
  };

  getUniversite(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.universiteAd;
        user.value = dt.universiteKod;
        dataList.push(user);
      });
    });

    return dataList;
  };

  getKod(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim;
        user.value = dt.kodId;
        dataList.push(user);
      });
    });

    return dataList;
  };

  getWebKod(url: string): Array<CustomCombo> {
    let dataList: Array<CustomCombo> = [];
    let resp = request({
      url: url,
      method: 'GET',
      headers: PYS_URL.HEADER,
    });

    resp.then(val => {
      val.data.map((dt) => {
        let user = new CustomCombo();
        user.name = dt.tanim;
        user.value = dt.kod;
        dataList.push(user);
      });
    });

    return dataList;
  };

  RAPOR(URL: string, raporTuru: string, ekran: string, raporAdi: string, dto: object) {
    let resp = request({
      url: URL,
      method: 'POST',
      headers: PYS_URL.HEADER,
      responseType: 'blob',
      params: { 'raporTuru': raporTuru, 'ekran': ekran, 'raporAdi': raporAdi },
      data: dto
    });

    resp.then(val => {
      if (raporTuru == 'PDF') {
        this.exportPDF(val.data, raporAdi);
      } else if (raporTuru == 'WORD') {
        this.exportDOCX(val.data, raporAdi);
      } else if (raporTuru == 'EXCEL') {
        this.exportXLSX(val.data, raporAdi);
      }
    });
  };

  exportPDF(data: BlobPart, name: string) {
    const url = window.URL.createObjectURL(new Blob([data]));
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute("download", name + ".pdf");
    document.body.appendChild(link);
    link.click();
  };

  exportDOCX(data: BlobPart, name: string) {
    const url = window.URL.createObjectURL(new Blob([data]));
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute("download", name + ".docx");
    document.body.appendChild(link);
    link.click();
  };


  exportXLSX(data: BlobPart, name: string) {
    const url = window.URL.createObjectURL(new Blob([data]));
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute("download", name + ".xlsx");
    document.body.appendChild(link);
    link.click();
  };



  showToast(type: ToastType, header: string, message: string) {
    switch (type) {
      case 0:
        this.toastr.info(message, header);
        break;
      case 1:
        this.toastr.error(message, header);
        break;
      case 2:
        this.toastr.warning(message, header);
        break;
      case 3:
        this.toastr.success(message, header);
        break;
    }
  };

}
