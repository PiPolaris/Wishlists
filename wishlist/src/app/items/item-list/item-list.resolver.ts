import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { ItemService } from '../item/item.service';
import { Item } from '../item/item';


@Injectable({providedIn: 'root'})
export class ItemListResolver implements Resolve<Observable<Item[]>>{

    constructor(private service: ItemService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) : Observable<Item[]> {
        const userId = route.params.userId;
        return this.service.listFromUserPaginated(userId, 0);
    }
}