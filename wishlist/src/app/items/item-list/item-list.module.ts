import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ItemModule } from '../item/item.module';
import { FilterByDescriptionPipe } from './filter-by-description.pipe';
import { ItemListComponent } from './item-list.component';
import { ItemsComponent } from './items/items.component';
import { LoadButtonComponent } from './load-button/load-button.component';
import { SearchComponent } from './search/search.component';
import { MainModule } from 'src/app/main/main.module';


@NgModule({
    declarations: [
        ItemListComponent,
        ItemsComponent,
        LoadButtonComponent,
        SearchComponent,
        FilterByDescriptionPipe       
    ],
    imports: [
        CommonModule,
        ItemModule,
        MainModule
    ]
})
export class ItemListModule { }