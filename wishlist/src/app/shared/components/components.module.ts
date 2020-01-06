import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RightMenuComponent } from './right-menu/right-menu.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { TopMenuComponent } from './top-menu/top-menu.component';
import { FeedbackMessagesComponent } from './feedback-messages/feedback-messages.component';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    TopMenuComponent,
    SideMenuComponent,
    RightMenuComponent,
    FeedbackMessagesComponent
  ],
  exports: [
    TopMenuComponent,
    SideMenuComponent,
    RightMenuComponent,
    FeedbackMessagesComponent
  ]
})
export class ComponentsModule { }
