import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from '../modal/modal.component';
import {FormControl} from '@angular/forms';
import {HotelsModel} from '../../models/hotels.model';
import {HotelsServiceService} from '../../services/hotels-service.service';
import {Router} from '@angular/router';
import {UsersModel} from '../../models/users.model';
import {UserServiceService} from '../../services/user-service.service';
import { DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {
  @ViewChild('hotelInfo') hotelInfo: ModalComponent;
  @ViewChild('hotelMap') hotelMap: ModalComponent;
  search = new FormControl('');
  hotels: HotelsModel[];
  hotelIndex: any;
  currentHotel: any;
  searchText;
  user: any;
  currentHotelMap: any;
  location: any;
  name: string;

  constructor(private hotelService: HotelsServiceService,
              private router: Router,
              private userService: UserServiceService,
              private dom: DomSanitizer) { }

  async ngOnInit(): Promise<void> {
    this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
    });
    this.user = this.userService.getUser();
  }
  showInfo(i): void {
    this.currentHotelMap = this.hotels[i]._id;
    this.location = this.currentHotelMap.location;
    this.hotelIndex = this.currentHotelMap._id;
    this.name = this.currentHotelMap.name;
    console.log('index vo hotels ' + i);
    console.log('hotel vo hotels ' + this.hotels[i]);
    this.router.navigate(['./hotel-info/' + i]);
  }
  showMap(hotel): void {
    this.currentHotelMap = hotel;
    this.location = this.currentHotelMap.location;
    console.log('location from hotels', this.currentHotelMap.name);
    this.hotelMap.show();
  }
  closeModal(): void {
    this.hotelInfo.hide();
  }
  private async listHotels(): Promise<void> {
    this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
    });
  }
  async deleteHotel(index): Promise<void> {
    await this.hotelService.deleteHotel(this.hotels[index]).subscribe(data => {
      this.hotels = data;
    });
    await this.listHotels();
  }
  async sortByStars(): Promise<void> {
    await this.hotelService.sortByStars().subscribe(data => {
      this.hotels = data;
    });
  }
  async sortAlphabetic(): Promise<void> {
    await this.hotelService.sortAlphabetic().subscribe(data => {
      this.hotels = data;
    });
  }
  addHotel(): void {
    this.router.navigate(['./add-edit']);
  }
}
