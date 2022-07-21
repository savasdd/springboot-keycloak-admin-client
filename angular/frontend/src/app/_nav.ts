import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Ana Sayfa',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info',
      text: ''
    }
  },
  {
    name: 'Personel Özlük',
    url: '/Personels',
    icon: 'icon-user',
    children: [
      {
        name: 'Özlük Bilgileri',
        url: '/Personels/PYSPersonel',
        icon: ' '
      },
    ]
  },
  {
    name: 'Genel Tanımlamalar',
    url: '/Genels',
    icon: 'icon-star',
    children: [
      {
        name: 'Kod Listesi',
        url: '/Genels/PYSKod',
        icon: ' '
      },
      {
        name: 'Kurum Bilgileri',
        url: '/Genels/PYSKurum',
        icon: ' '
      },
      {
        name: 'Genel Parametreler',
        url: '/Genels/PYSParametre',
        icon: ' '
      },
      {
        name: 'İl-İlçe Tanımlama',
        url: '/Genels/PYSIl',
        icon: ' '
      },
      {
        name: 'İş Yeri Tanımlama',
        url: '/Genels/PYSIsYeri',
        icon: ' '
      },
      {
        name: 'Konum Bilgisi',
        url: '/Genels/PYSKonum',
        icon: ' '
      },
      {
        name: 'Birim Tanımlama',
        url: '/Genels/PYSBirim',
        icon: ' '
      },
      {
        name: 'Personel Türü',
        url: '/Genels/PYSPersonelTuru',
        icon: ' '
      },
      {
        name: 'Öğrenim Bilgileri',
        url: '/Genels/PYSOgrenim',
        icon: ' '
      }
    ]
  },
  {
    name: 'Log Ekranları',
    url: '/Logs',
    icon: 'cil-laptop',
    children: [
      {
        name: 'Kullanıcı Log İzleme',
        url: '/Logs/PYSLogKullanici',
        icon: ' '
      },
      {
        name: 'Hata Log İzleme',
        url: '/Logs/PYSLogHata',
        icon: ' '
      },
      {
        name: 'İşlem Log İzleme',
        url: '/Logs/PYSLogIslem',
        icon: ' '
      }
    ]
  },
  {
    name: 'Dinamik Web Servisi',
    url: '/Dinamiks',
    icon: 'cil-layers',
  },
  {
    name: 'Sistem Ekranları',
    url: '/Sistems',
    icon: 'icon-settings',
    children: [
      {
        name: 'Rol Tanımlama',
        //url: '/Sistems/alerts',
        url: '/Sistems/PYSRol',
        icon: ' '
      },
      {
        name: 'Rol Grupları',
        url: '/Sistems/PYSRolGrup',
        icon: ' '
      },
      {
        name: 'Kullanıcı Bilgileri',
        url: '/Sistems/PYSKullanici',
        icon: ' '
      }
    ]
  },

  {
    name: 'Raporlar',
    url: '/Rapors',
    icon: 'icon-list',
    children: [
      {
        name: 'Kod Raporları',
        url: '/Rapors/PYSKodRapor',
        icon: ' '
      },
      {
        name: 'Personel Raporları',
        url: '/Rapors/PYSPersonelRapor',
        icon: ' '
      },
    ]
  },
  {
    name: 'Çıkış Yap',
    url: '/logout',
    icon: 'cil-lock-locked'
  }
];
