import { Component, OnInit } from '@angular/core';
import { Item } from '../item/item';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../item/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  items: Item[] = [];
  filter: string = '';
  hasMore: boolean = true;
  currentPage: number = 0;
  userId: number = 0;

  constructor(
    private activatedRoute: ActivatedRoute,
    private itemService: ItemService
  ) { }

  ngOnInit() {
    this.userId = this.activatedRoute.snapshot.params.userId;
    this.items = this.activatedRoute.snapshot.data['items'];
  }

  load() {
    this.itemService
      .listFromUserPaginated(this.userId, ++this.currentPage)
      .subscribe(items => {
        this.filter = '';
        this.items.content = this.items.content.concat(items.content);
        if (!items.content.length) this.hasMore = false;
      });
  }
}