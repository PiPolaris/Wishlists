import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Item } from './item';

const API = 'http://localhost:8080';

@Injectable({ providedIn: 'root' })
export class ItemService {
    constructor(private http: HttpClient) { }

    /*listFromUserId(wishId: number) {
        return this.http
            .get<Item[]>(API + '/wishlists/' + wishId);
    }*/

    listFromUserPaginated(wishId: number, page: number) {
        const params = new HttpParams()
            .append('page', page.toString())
            .append('wishId', wishId.toString());

        return this.http
            .get<Item[]>(API + '/item', { params });
    }
}