import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../item/item';

@Pipe({ name: 'filterByDescription' })
export class FilterByDescriptionPipe implements PipeTransform {

  transform(items: Item[], descriptionQuery: string) {
    descriptionQuery = descriptionQuery.trim().toLowerCase();

    if (descriptionQuery) {
      return items.filter(item => item.name.toLowerCase().includes(descriptionQuery));
    } else {
      return items;
    }
  }

}
