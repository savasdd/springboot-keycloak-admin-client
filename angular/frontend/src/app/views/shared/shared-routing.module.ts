import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from '../shared/pages/admin/admin.component';

// const routes: Routes = [
//     {
//         path: '', data: { title: 'Genel Tanımlamalar' },
//         children: [
//             { path: '', component: AdminComponent, data: { title: 'Sınav Sonuçları' } },
//         ]
//     },
// ];

const routes: Routes = [
    {
        path: '', component: AdminComponent, data: { title: 'Sınav Sonuçları' }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SharedRoutingModule { }
