import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HotelsServiceService} from "../../services/hotels-service.service";
import {HotelsModel} from "../../models/hotels.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-hotel-info',
  templateUrl: './hotel-info.component.html',
  styleUrls: ['./hotel-info.component.css']
})
export class HotelInfoComponent implements OnInit {
  hotel: HotelsModel = new HotelsModel();
  hotels: HotelsModel[];

  constructor(
      private hotelService: HotelsServiceService,
      private route: ActivatedRoute
  ) {
  }
  async ngOnInit(): Promise<void> {
    const hotelIndex: number = +this.route.snapshot.paramMap.get('i');
    await this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
      this.hotel = this.hotels[hotelIndex];
      console.log('index vo hotel info ' + hotelIndex);
      console.log('hotel vo hotel info ' + this.hotels[hotelIndex]);
    });
  }

}
