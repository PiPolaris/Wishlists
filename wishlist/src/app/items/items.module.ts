import { NgModule } from '@angular/core';
import { ItemModule } from './item/item.module';
import { ItemListModule } from './item-list/item-list.module';
import { NewItemComponent } from './new-item/new-item.component';

@NgModule({
  imports: [
    ItemModule,
    ItemListModule
  ],
  declarations: [NewItemComponent]
})
export class ItemsModule { }
