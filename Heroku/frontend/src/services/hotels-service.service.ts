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
    return this.http.post<HotelsModel>(`${this.hotelsUrl}/save`, hotel);
  }
  public findAll(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(this.hotelsUrl);
  }
  // edit
  public editHotel(data: HotelsModel, id: string): Promise<HotelsModel> {
    return this.http
      .put<HotelsModel>(`${this.hotelsUrl}/edit?id=${id}`, data)
      .toPromise();
  }
  // delete
  // deleteHotel(id: string): Promise<HotelsModel> {
  //   return this.http.delete<HotelsModel>(`${this.hotelsUrl}/delete?id=${id}`).toPromise() ;
  // }
  deleteHotel(hotel: HotelsModel): Observable<HotelsModel[]> {
    return this.http.post<HotelsModel[]>(`${this.hotelsUrl}/delete`, hotel);
  }
  // sort
  public sortByStars(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(`${this.hotelsUrl}/sortbystars`);
  }

  public sortByPrice(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(`${this.hotelsUrl}/sortbyprice`);
  }
  // search
  // AIzaSyDB4R7MbHUmwlExVnCjwinN4xzzGd4-C14

}
