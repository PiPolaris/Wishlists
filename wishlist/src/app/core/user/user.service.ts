import { Injectable } from '@angular/core';
import { TokenService } from '../token/token.service';
import { Subject, BehaviorSubject } from 'rxjs';
import { User } from 'src/app/home/user';

@Injectable({ providedIn: 'root' })
export class UserService {

    //private userSubject = new Subject<any>();
    private userSubject = new BehaviorSubject<User>(null);
    private userId: string;

    constructor(private tokenService: TokenService) { 
        this.tokenService.hasToken() && this.notify();
    }

    setToken(token: User) {
        this.tokenService.setToken(token);
    }

    getUser() {
        return this.userSubject.asObservable();
    }

    private notify() {
        const user = this.tokenService.getToken();               
        this.userId = user ? user.id : null;
        this.userSubject.next(user.name);
    }

    logout() {
        this.tokenService.removeToken();
        this.userSubject.next(null);
    }

    isLogged() {
        return this.tokenService.hasToken();
    }

    getUserId(){
        return this.userId;
    }
}