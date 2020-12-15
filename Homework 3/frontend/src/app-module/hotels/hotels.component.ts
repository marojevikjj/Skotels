import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from '../modal/modal.component';
import {FormControl} from '@angular/forms';
import {HotelsModel} from '../../models/hotels.model';
import {HotelsServiceService} from '../../services/hotels-service.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {
  @ViewChild('hotelInfo') hotelInfo: ModalComponent;
  search = new FormControl('');
  hotels: HotelsModel[];
  // hotels = [
  //   {
  //     name: 'Tccplaza',
  //     email: 'gmail',
  //     phone: '07845098',
  //     stars: '5',
  //     website: 'www.booking.com',
  //     city: 'skopje',
  //     street: 'ulica',
  //     internetAccess: 'yes',
  //     rooms: '100',
  //     fee: 'no'
  //   },
  //   {
  //     name: 'test'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  //   {
  //     name: 'Tccplaza'
  //   },
  // ];
  currentHotel = {};

  constructor(private hotelService: HotelsServiceService) { }

  ngOnInit(): void {
    this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
      console.log(this.hotels);
    });
  }
  show_info(hotel): void {
    this.currentHotel = hotel;
    this.hotelInfo.show();
  }
  close_modal(): void {
    this.hotelInfo.hide();
  }
}
