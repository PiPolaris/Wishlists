import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../../home/user';
import { tap } from 'rxjs/operators';
import { TokenService } from '../token/token.service';

const API_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private tokenService: TokenService) { }

  authenticate(email: string, password: string) {
    return this.http.post(
      API_URL + '/login', 
      { email, senha: password }, 
      { observe: 'response' }
    )
    .pipe(tap(res => {
      const authToken:string = res.body.token;
      this.tokenService.setToken(authToken);
      console.log(authToken);
    }));
  }

  getId(email: string) {
    return this.http.get<User>(API_URL + '/users?email=' + email);
  }
}
