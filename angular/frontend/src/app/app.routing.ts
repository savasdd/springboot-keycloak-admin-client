import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import { DefaultLayoutComponent } from './containers';
import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';
import { LoginComponent } from './views/login/login.component';
import { LogoutComponent } from './views/login/logout/logout.component';

export const routes: Routes = [
  // { path: '', redirectTo: 'login', pathMatch: 'full', },
  { path: '', redirectTo: 'login', pathMatch: 'full', },
  { path: '404', component: P404Component, data: { title: 'Page 404' } },
  { path: '500', component: P500Component, data: { title: 'Page 500' } },
  { path: 'login', component: LoginComponent, data: { title: 'Login Page' } },
  //{ path: 'logout', component: LogoutComponent, data: { title: 'Login Page' } },
  {
    path: '', component: DefaultLayoutComponent, data: { title: 'Ana Sayfa' },
    children:
      [
        { path: 'home', loadChildren: () => import('./views/dashboard/dashboard.module').then(m => m.DashboardModule) },
        { path: 'admin', loadChildren: () => import('./views/shared/shared.module').then(m => m.SharedModule) },
      ]
  },
  { path: '**', component: P404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
