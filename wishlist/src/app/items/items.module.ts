import { NgModule } from '@angular/core';
import { ItemModule } from './item/item.module';
import { ItemListModule } from './item-list/item-list.module';

@NgModule({
  imports: [
    ItemModule,
    ItemListModule
  ],
  declarations: []
})
export class ItemsModule { }
