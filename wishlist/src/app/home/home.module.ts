import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms'
import { SigninComponent } from './signin/signin.component';
import { SignoutComponent } from './signout/signout.component';
import { ComponentsModule } from '../shared/components/components.module';
import { AppRoutingModule } from '../app.routing.module';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ComponentsModule,
    RouterModule
  ],
  declarations: [
    SigninComponent,
    SignoutComponent
  ]
})
export class HomeModule { }
