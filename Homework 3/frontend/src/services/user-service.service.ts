import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { UsersModel} from '../models/users.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private usersUrl: string;
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }
  public register(user: UsersModel): Observable<UsersModel> {
    return this.http.post<UsersModel>(this.usersUrl, user);
  }
  // login admin
  // login user
}
