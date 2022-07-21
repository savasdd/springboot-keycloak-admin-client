import { Cookie } from 'ng2-cookies/ng2-cookies';
import { HttpHeaders } from "@angular/common/http";

let _BASE = "http://localhost:8084/api/";

export class PYS_URL {

    static HEADER = {
        'Content-Type': 'application/json; charset=utf-8',
        'Authorization': `Bearer ${Cookie.get('tkn')}`,
        //'Access-Control-Allow-Origin': '*',
    };

    static GET_TOKEN = _BASE + 'auth/getToken';
    static GET_REFRESH_TOKEN = _BASE + 'auth/' + 'refreshToken';
    static GVN_MENU = _BASE + 'kullanicis/component/menu';
    static GVN_MENU_ALL = _BASE + 'kullanicis/menu';

    static PARAMETRE_GET_ALL = _BASE + 'systems/';
    static PARAMETRE_CREATE = _BASE + 'systems';
    static PARAMETRE_UPDATE = _BASE + 'systems/';
    static PARAMETRE_DELETE = _BASE + 'systems/';
    static PARAMETRE_GET_ISYERI_ALL = _BASE + 'systems/isyeri/';

    static PARAM_GET_ALL = _BASE + 'parametres/';
    static PARAM_CREATE = _BASE + 'parametres';
    static PARAM_UPDATE = _BASE + 'parametres/';
    static PARAM_DELETE = _BASE + 'parametres/';

    static KOD_GET_ALL = _BASE + 'kod/all';
    static KOD_GET_BY_USTKOD = _BASE + 'kod/ustkod/';
    static KOD_GET_BY_USTKOD_NOT = _BASE + 'kod/ustkodnot/';
    static KOD_GET_BY_DETAY_USTKOD = _BASE + 'personels/ogrenims/durumlar/';
    static KOD_GET_DETAY_KODS = _BASE + 'kod/ustkoddetay/';
    static KOD_GET_BY_PAGE = _BASE + 'gnlkod/pages/';
    static KOD_CREATE = _BASE + 'kod';
    static KOD_UPDATE = _BASE + 'kod/';
    static KOD_DELETE = _BASE + 'kod/';
    static KOD_ALERT = _BASE + 'kod/alert';
    static KODS = _BASE + 'kods';

    static GVN_ROL_GET_ALL = _BASE + 'rols/';
    static GVN_ROL_GET_BY_UST_ROL = _BASE + 'rols/ustRolNo/';
    static GVN_ROL_CREATE = _BASE + 'rols';
    static GVN_ROL_UPDATE = _BASE + 'rols/';
    static GVN_ROL_DELETE = _BASE + 'rols/';

    static ISLEM_LOG_GET_PARAM = _BASE + 'logs/islem';
    static HATA_LOG_GET_PARAM = _BASE + 'logs/hata';
    static KULLANICI_LOG_GET_PARAM = _BASE + 'logs/kullanici';

    static GVN_ROL_GRUP_GET_ALL = _BASE + 'rolgrups/';
    static GVN_ROL_GRUP_CREATE = _BASE + 'rolgrups';
    static GVN_ROL_GRUP_UPDATE = _BASE + 'rolgrups/';
    static GVN_ROL_GRUP_DELETE = _BASE + 'rolgrups/';
    static GVN_ROL_GRUP_COPY = _BASE + 'rolgrups/kopyala';

    static GVN_ROL_GRUP_ROL_GET_ALL = _BASE + 'rolgruprols/';
    static GVN_ROL_GRUP_ROL_GET_GRUP = _BASE + 'rolgruprols/grup/';
    static GVN_ROL_GRUP_ROL_CREATE = _BASE + 'rolgruprols';
    static GVN_ROL_GRUP_ROL_UPDATE = _BASE + 'rolgruprols/';
    static GVN_ROL_GRUP_ROL_DELETE = _BASE + 'rolgruprols/';

    static GVN_KULLANICI_GET_ALL = _BASE + 'kullanicis/';
    static GVN_KULLANICI_GET_FOTO = _BASE + 'kullanicis/fotograf';
    static GVN_KULLANICI_GET_ISYERI = _BASE + 'kullanicis/isyeri/';
    static GVN_KULLANICI_CREATE = _BASE + 'kullanicis';
    static GVN_KULLANICI_UPDATE = _BASE + 'kullanicis/';
    static GVN_KULLANICI_DELETE = _BASE + 'kullanicis/';
    static GVN_KULLANICI_SIFRE = _BASE + 'kullanicis/sifre';

    static GVN_KULLANICI_GRUP_GET_ALL = _BASE + 'kullanicigrups/';
    static GVN_KULLANICI_GRUP_GET = _BASE + 'kullanicigrups/grup/';
    static GVN_KULLANICI_GRUP_CREATE = _BASE + 'kullanicigrups';
    static GVN_KULLANICI_GRUP_UPDATE = _BASE + 'kullanicigrups/';
    static GVN_KULLANICI_GRUP_DELETE = _BASE + 'kullanicigrups/';

    static GVN_KURUM_GET = _BASE + 'kurum/';
    static GVN_KURUM_BY_ISYERI_GET = _BASE + 'kurum/kullanicisyeri/';
    static GVN_KURUM_CREATE = _BASE + 'kurum';
    static GVN_KURUM_UPDATE = _BASE + 'kurum/';
    static GVN_KURUM_DELETE = _BASE + 'kurum/';

    static GVN_IS_YERI_GET = _BASE + 'isyeri/';
    static GVN_IS_YERI_GET_KURUM = _BASE + 'isyeri/kurum/';
    static GVN_IS_YERI_CREATE = _BASE + 'isyeri';
    static GVN_IS_YERI_UPDATE = _BASE + 'isyeri/';
    static GVN_IS_YERI_DELETE = _BASE + 'isyeri/';

    static GVN_IL_GET = _BASE + 'il';
    static GVN_IL_CREATE = _BASE + 'il';
    static GVN_IL_UPDATE = _BASE + 'il/';
    static GVN_IL_DELETE = _BASE + 'il/';

    static GVN_ILCE_GET = _BASE + 'gnlilce/';
    static GVN_IL_ILCE_GET = _BASE + 'gnlilce/il/';
    static GVN_ILCE_CREATE = _BASE + 'gnlilce/create';
    static GVN_ILCE_UPDATE = _BASE + 'gnlilce/update/';
    static GVN_ILCE_DELETE = _BASE + 'gnlilce/delete/';

    static GVN_KONUM_GET = _BASE + 'konums/';
    static GVN_KONUM_ISYERI_GET = _BASE + 'konums/isyeri/';
    static GVN_KONUM_CREATE = _BASE + 'konums';
    static GVN_KONUM_UPDATE = _BASE + 'konums/';
    static GVN_KONUM_DELETE = _BASE + 'konums/';

    static GVN_KONUM_DETAY_GET = _BASE + 'konumdetays/';
    static GVN_KONUM_DETAY_KONUM_GET = _BASE + 'konumdetays/isyeri/';
    static GVN_KONUM_DETAY_CREATE = _BASE + 'konumdetays';
    static GVN_KONUM_DETAY_UPDATE = _BASE + 'konumdetays/';
    static GVN_KONUM_DETAY_DELETE = _BASE + 'konumdetays/';

    static GVN_BIRIM_GET = _BASE + 'birim/byid';
    static GVN_BIRIM_ISYERI_GET = _BASE + 'birim/isyeri/';
    static GVN_BIRIM_KURULUS_GET = _BASE + 'birim/baglikurulus/';
    static GVN_BIRIM_CREATE = _BASE + 'birim';
    static GVN_BIRIM_UPDATE = _BASE + 'birim';
    static GVN_BIRIM_DELETE = _BASE + 'birim/';
    static GVN_BIRIM_YETKI = _BASE + 'birim/yetki';
    static GVN_BIRIM_PARA = _BASE + 'birim/param';
    static GVN_BIRIM_ISYERI = _BASE + 'birim/isyeri';

    static GVN_OKUL_GET = _BASE + 'gnluniversite/';
    static GVN_OKUL_CREATE = _BASE + 'gnluniversite/create';
    static GVN_OKUL_UPDATE = _BASE + 'gnluniversite/update/';
    static GVN_OKUL_DELETE = _BASE + 'gnluniversite/delete/';
    static GVN_OKUL_UNIVERSITE = _BASE + 'gnluniversite/universite';
    static GVN_OKUL_FAKULTE = _BASE + 'gnluniversite/fakulte/';
    static GVN_OKUL_BOLUM = _BASE + 'gnluniversite/bolum/';
    static GVN_OKUL_BY_UNIVERSITE = _BASE + 'gnluniversite/byuniversite/';

    static SCL_PERSONEL_GET = _BASE + 'personel/';
    static SCL_PERSONEL_PARAM_GET = _BASE + 'personel/param';
    static SCL_PERSONEL_CREATE = _BASE + 'personel';
    static SCL_PERSONEL_UPDATE = _BASE + 'personel/';
    static SCL_PERSONEL_DELETE = _BASE + 'personel/';
    static SCL_PERSONEL_YETKI = _BASE + 'personel/yetki';
    static SCL_PERSONELS = _BASE + 'personels/';
    static PERSONELS = _BASE + 'personels';

    static SCL_ASKERLIK_GET = _BASE + 'sclaskerlik/';
    static SCL_ASKERLIK_PERS_GET = _BASE + 'personels/askerliks/';
    static SCL_ASKERLIK_CREATE = _BASE + 'personels/askerliks';
    static SCL_ASKERLIK_UPDATE = _BASE + 'personels/askerliks/';
    static SCL_ASKERLIK_DELETE = _BASE + 'personels/askerliks/';
    static SCL_ASKERLIK_YETKI = _BASE + 'personels/askerliks/yetki';

    static SCL_ADRES_GET = _BASE + 'scladres/';
    static SCL_ADRES_PERS_GET = _BASE + 'personels/adress/';
    static SCL_ADRES_YETKI = _BASE + 'personels/adress/yetki';
    static SCL_ADRESS = '/adress';
    static SCL_ADRESU = '/adress/';

    static SCL_OGRENIM_GET = _BASE + 'sclogrenim/';
    static SCL_OGRENIM_PERS_GET = _BASE + 'personels/ogrenims/';
    static SCL_OGRENIM_CREATE = _BASE + 'personels/ogrenims';
    static SCL_OGRENIM_UPDATE = _BASE + 'personels/ogrenims/';
    static SCL_OGRENIM_DELETE = _BASE + 'personels/ogrenims/';
    static SCL_OGRENIM_YETKI = _BASE + 'personels/ogrenims/yetki';

    static SCL_EGITIM_GET = _BASE + 'sclegitim/';
    static SCL_EGITIM_PERS_GET = _BASE + 'personels/egitims/';
    static SCL_EGITIM_CREATE = _BASE + 'personels/egitims';
    static SCL_EGITIM_UPDATE = _BASE + 'personels/egitims/';
    static SCL_EGITIM_DELETE = _BASE + 'personels/egitims/';
    static SCL_EGITIM_YETKI = _BASE + 'personels/egitims/yetki';

    static SCL_FOTO_GET = _BASE + 'sclfotograf/';
    static SCL_FOTO_PERSONEL_GET = _BASE + 'personels/fotografs/';
    static SCL_FOTO_CREATE = _BASE + 'personels/fotografs';
    static SCL_FOTO_UPDATE = _BASE + 'personels/fotografs/';
    static SCL_FOTO_DELETE = _BASE + 'personels/fotografs/';

    static SCL_DIL_GET = _BASE + 'sclyabancidil/';
    static SCL_DIL_PERS_GET = _BASE + 'personels/yabancidils/';
    static SCL_DIL_CREATE = _BASE + 'personels/yabancidils';
    static SCL_DIL_UPDATE = _BASE + 'personels/yabancidils/';
    static SCL_DIL_DELETE = _BASE + 'personels/yabancidils/';
    static SCL_DIL_YETKI = _BASE + 'personels/yabancidils/yetki';

    static SCL_HIZMET_GET = _BASE + 'sclhizmet/';
    static SCL_HIZMET_PERS_GET = _BASE + 'personels/hizmets/';
    static SCL_HIZMET_CREATE = _BASE + 'personels/hizmets';
    static SCL_HIZMET_UPDATE = _BASE + 'personels/hizmets/';
    static SCL_HIZMET_DELETE = _BASE + 'personels/hizmets/';
    static SCL_HIZMET_YETKI = _BASE + 'personels/hizmets/yetki';

    static SCL_GOREV_GET = _BASE + 'sclgorev/';
    static SCL_GOREV_PERS_GET = _BASE + 'personels/gorevs/';
    static SCL_GOREV_CREATE = _BASE + 'personels/gorevs';
    static SCL_GOREV_UPDATE = _BASE + 'personels/gorevs/';
    static SCL_GOREV_DELETE = _BASE + 'personels/gorevs/';
    static SCL_GOREV_YETKI = _BASE + 'personels/gorevs/yetki';
    static SCL_GOREVS = _BASE + 'gorevs';

    static KULLANICI_BIRIM_GET = _BASE + 'kullanicibirims/';
    static KULLANICI_BY_BIRIM_GET = _BASE + 'kullanicibirims/kullanici/';
    static KULLANICI_BIRIM_CREATE = _BASE + 'kullanicibirims';
    static KULLANICI_BIRIM_UPDATE = _BASE + 'kullanicibirims/';
    static KULLANICI_BIRIM_DELETE = _BASE + 'kullanicibirims/';
    static KULLANICI_BY_BIRIMS_GET = _BASE + 'kullanicibirims/kullanici';

    static KULLANICI_PERSONEL_GET = _BASE + 'kullanicipersonels/';
    static KULLANICI_BY_PERSONEL_GET = _BASE + 'kullanicipersonels/kullanici/';
    static KULLANICI_PERSONEL_CREATE = _BASE + 'kullanicipersonels';
    static KULLANICI_PERSONEL_UPDATE = _BASE + 'kullanicipersonels/';
    static KULLANICI_PERSONEL_DELETE = _BASE + 'kullanicipersonels/';

    static KULLANICI_ISYERI_GET = _BASE + 'kullanicisyeris/';
    static KULLANICI_BY_ISYERI_GET = _BASE + 'kullanicisyeris/kullanici/';
    static KULLANICI_ISYERI_CREATE = _BASE + 'kullanicisyeris';
    static KULLANICI_ISYERI_UPDATE = _BASE + 'kullanicisyeris/';
    static KULLANICI_ISYERI_DELETE = _BASE + 'kullanicisyeris/';

    static PERSONEL_TURU_GET = _BASE + 'personelturu/';
    static PERSONEL_TURU_KULLANICI_GET = _BASE + 'personelturu/kullanicipersonel/';
    static PERSONEL_TURU_KIRILIM_GET = _BASE + 'personelturu/kirilim';
    static PERSONEL_TURU_CREATE = _BASE + 'personelturu';
    static PERSONEL_TURU_UPDATE = _BASE + 'personelturu/';
    static PERSONEL_TURU_DELETE = _BASE + 'personelturu/';

    static WEB_SERVICE_GET = _BASE + 'dinamiks';
    static WEB_SERVICE_META_DATA_TABLE = _BASE + 'metas';
    static WEB_SERVICE_META_DATA_COLUMNS = _BASE + 'metas/columns';
    static WEB_SERVICE_META_DATA_GET = _BASE + 'metas/datas';
    static WEB_SERVICE_META_DATA_MODEL = _BASE + 'metas/rsql';

    static KOD_RAPOR_PDF = _BASE + 'rapors';
    static GNL_RAPOR = _BASE + 'rapors';

}

export const GridDef = {
    sortable: true,
    editable: false,
    filter: true,
    floatingFilter: true,
    enableCellChangeFlash: true,
};

export const overlayLoading = '<span class="ag-overlay-loading-center">Veri Yükleniyor</span>';
export const overlayNoRows = '<span style="padding: 10px; border: 0px solid #444;font-weight: bold;font-size: 0.8rem;">Veri Bulunamadı</span>';
export const overlayNoRows1 = '<span style="padding: 10px; border: 0px solid #444; background: lightgoldenrodyellow;">Veri Bulunamadı</span>';