import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UsersModel} from '../models/users.model';
import {Observable} from 'rxjs';
import {HotelsModel} from '../models/hotels.model';

@Injectable({
  providedIn: 'root'
})
export class HotelsServiceService {
  private hotelsUrl: string;
  constructor(private http: HttpClient) {
    this.hotelsUrl = 'http://localhost:8080/api/hotels';
  }
  public add(hotel: HotelsModel): Observable<HotelsModel> {
    return this.http.post<HotelsModel>(this.hotelsUrl, HotelsModel);
  }
  public findAll(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(this.hotelsUrl);
  }
  // edit
  // delete
  // sort
  // search



}
