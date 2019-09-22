import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ItemComponent } from './item.component';


@NgModule({
    declarations: [ItemComponent],
    imports: [
        CommonModule,
        HttpClientModule
    ],
    exports: [ItemComponent]
})
export class ItemModule { }