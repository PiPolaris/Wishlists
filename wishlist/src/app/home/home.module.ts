import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms'
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ComponentsModule } from '../shared/components/components.module';
import { AppRoutingModule } from '../app.routing.module';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ComponentsModule,
    RouterModule,
    FormsModule
  ],
  declarations: [
    SigninComponent,
    SignupComponent
  ]
})
export class HomeModule { }
