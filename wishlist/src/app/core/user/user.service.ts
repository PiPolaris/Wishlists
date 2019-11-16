import { Injectable } from '@angular/core';
import { TokenService } from '../token/token.service';
import { Subject } from 'rxjs';
import { User } from 'src/app/home/user';

@Injectable({ providedIn: 'root' })
export class UserService {

    private userSubject = new Subject<any>();

    constructor(private tokenService: TokenService) { 
        this.tokenService.hasToken() && this.notify();
    }

    setToken(token: string) {
        this.tokenService.setToken(token);
    }

    getUser() {
        return this.userSubject.asObservable();
    }

    private notify() {
        const user = this.tokenService.getToken();
        this.userSubject.next(user);
    }
}