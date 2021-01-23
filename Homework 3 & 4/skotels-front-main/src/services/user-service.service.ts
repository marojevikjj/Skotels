import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { UsersModel} from '../models/users.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private usersUrl: string;
  private user: UsersModel = null;
  constructor(private http: HttpClient) {
    this.usersUrl = 'https://skotels2.herokuapp.com/api';
  }
  public register(user: UsersModel): Observable<UsersModel> {
    return this.http.post<UsersModel>(`${this.usersUrl}/signup`, user);
  }
  // login admin
  login(user: UsersModel): Observable<UsersModel>{
    return this.http.post<UsersModel>(`${this.usersUrl}/login`, user);
  }
  getUser(): UsersModel {
    return this.user;
  }
  setUser(current: UsersModel): void {
    this.user = current;
  }
}
