import { NgModule } from '@angular/core';
import { SideMenuComponent } from '../shared/components/side-menu/side-menu.component';
import { TopMenuComponent } from '../shared/components/top-menu/top-menu.component';
import { MainComponent } from './main.component';
import { RightMenuComponent } from '../shared/components/right-menu/right-menu.component';

@NgModule({
    declarations: [
        MainComponent,
        SideMenuComponent,
        TopMenuComponent,
        RightMenuComponent
    ],
    exports: [
        MainComponent,
        SideMenuComponent,
        TopMenuComponent,
        RightMenuComponent
    ]
  })
  export class MainModule { }