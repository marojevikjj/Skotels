import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HotelsModel} from '../models/hotels.model';
import {HotelsComment} from "../models/comment.model";

@Injectable({
  providedIn: 'root'
})
export class HotelsServiceService {
  private hotelsUrl: string;
  constructor(private http: HttpClient) {
    // this.hotelsUrl = 'https://skotels2.herokuapp.com/api/hotels';
    this.hotelsUrl = 'http://localhost:8080/api/hotels';
  }
  public add(hotel: HotelsModel): Observable<HotelsModel> {
    return this.http.post<HotelsModel>(`${this.hotelsUrl}/save`, hotel);
  }
  public addNewComment(comment: HotelsComment): Observable<HotelsModel> {
    return this.http.post<HotelsModel>(`${this.hotelsUrl}/saveComment`, comment);
  }
  public findAll(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(`${this.hotelsUrl}`);
  }
  public getComments(hotel: HotelsModel): Observable<HotelsComment[]>{
    return this.http.get<HotelsComment[]>(`${this.hotelsUrl}/getComments`, hotel);
  }
  // delete
  deleteHotel(hotel: HotelsModel): Observable<HotelsModel[]> {
    return this.http.post<HotelsModel[]>(`${this.hotelsUrl}/delete`, hotel);
  }
  // sort
  public sortByStars(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(`${this.hotelsUrl}/sortbystars`);
  }

  public sortAlphabetic(): Observable<HotelsModel[]> {
    return this.http.get<HotelsModel[]>(`${this.hotelsUrl}/sortalphabetic`);
  }
}
