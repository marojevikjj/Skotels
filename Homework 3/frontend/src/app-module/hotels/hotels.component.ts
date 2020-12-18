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

  constructor(private hotelService: HotelsServiceService,
              private router: Router,
              private userService: UserServiceService,
              private dom: DomSanitizer) { }

  ngOnInit(): void {
    this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
    });
    this.user = this.userService.getUser();
  }
  show_info(hotel): void {
    this.currentHotel = hotel;
    this.hotelInfo.show();
  }
  show_map(hotel): void {
    this.currentHotelMap = hotel;
    this.location = this.currentHotelMap.location;
    console.log('location from hotels',this.location)
    this.hotelMap.show();
  }
  close_modal(): void {
    this.hotelInfo.hide();
  }
  private async list_hotels(): Promise<void> {
    this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
    });
  }
  async deleteHotel(index): Promise<void> {
    await this.hotelService.deleteHotel(this.hotels[index]._id).subscribe();
    await this.list_hotels();
  }
  async sort_stars(): Promise<void> {
    await this.hotelService.sortByStars().subscribe(data => {
      this.hotels = data;
    });
  }
  async sort_price(): Promise<void> {
    await this.hotelService.sortByPrice().subscribe(data => {
      this.hotels = data;
    });
  }
  add_hotel(): void {
    this.router.navigate(['./add-edit']);
  }
}
