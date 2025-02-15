import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private http: HttpClient
  ) { }

  postLogin(loginDTO: any): Observable<any> {
    return this.http.post(BASIC_URL + "api/guest/user/login", loginDTO)
  }
}
