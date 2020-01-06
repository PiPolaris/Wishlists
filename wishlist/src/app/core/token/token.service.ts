import { Injectable } from '@angular/core';
import { User } from 'src/app/home/user';
import { UserService } from '../user/user.service';

@Injectable({ providedIn: 'root' })
export class TokenService {
    private userService: UserService;
    private token: User[] = [];

    hasToken() {
        return !!this.getToken();
    }

    setToken(token) {
        this.token = token;
        window.localStorage.setItem('userId', token.id);
        window.localStorage.setItem('userName', token.name);
    }

    getToken() {
        this.token.id = window.localStorage.getItem('userId');
        this.token.name = window.localStorage.getItem('userName');
        return this.token;
    }

    removeToken() {
        window.localStorage.removeItem('userId');
        window.localStorage.removeItem('userName');
    }
}