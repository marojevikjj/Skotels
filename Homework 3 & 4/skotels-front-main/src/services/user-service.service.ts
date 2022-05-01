import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { UsersModel} from '../models/users.model';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
   usersUrl: string;
   user: UsersModel = null;
   loggedIn = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient) {
    this.usersUrl = 'https://skotels2.herokuapp.com/api';
    // this.usersUrl = 'http://localhost:8080/api/auth';
  }
  public register(user: UsersModel): Observable<UsersModel> {
    return this.http.post<UsersModel>(`${this.usersUrl}/signup`, user);
  }
  // login
  login(user: UsersModel): Observable<UsersModel>{
    return this.http.post<UsersModel>(`${this.usersUrl}/login`, user);
  }
  getUser(): UsersModel {
    return this.user;
  }
  setUser(current: UsersModel): void {
    this.user = current;
  }
  logout(): Observable<void>{
    return this.http.post<void>(`${this.usersUrl}/logout`, null);
  }
}
