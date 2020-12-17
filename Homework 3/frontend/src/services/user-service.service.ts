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
    this.usersUrl = 'http://localhost:8080/api';
  }
  public register(user: UsersModel): Observable<UsersModel> {
    return this.http.post<UsersModel>(`${this.usersUrl}/signup`, user);
  }
  // login admin
  login(data: UsersModel){
    return this.http.post<UsersModel>(`${this.usersUrl}/login`, data).toPromise();
  }
}
