import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginModule } from "../login/login.module";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgGridModule } from 'ag-grid-angular';
import { PanelModule } from 'primeng/panel';
import { DropdownModule } from 'primeng/dropdown';
import { MatSliderModule } from '@angular/material/slider';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { TabViewModule } from 'primeng/tabview';
import { ToastrModule, ToastContainerModule } from 'ngx-toastr';

import { SharedRoutingModule } from "../shared/shared-routing.module";
import { AdminComponent } from './pages/admin/admin.component';


@NgModule({
  declarations: [
    AdminComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    LoginModule,
    SharedRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AgGridModule.withComponents([]),
    PanelModule,
    DropdownModule,
    MatSliderModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    MatSelectModule,
    MatCardModule,
    ButtonModule,
    CalendarModule,
    TabViewModule,
    ToastrModule.forRoot(),
    ToastContainerModule,
  ],
  exports: [
  ]
})
export class SharedModule { }