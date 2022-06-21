import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HotelsServiceService} from "../../services/hotels-service.service";
import {HotelsModel} from "../../models/hotels.model";
import {HotelsComment} from "../../models/comment.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-hotel-info',
  templateUrl: './hotel-info.component.html',
  styleUrls: ['./hotel-info.component.css']
})
export class HotelInfoComponent implements OnInit {
  // @Input() hotel: any;
  // @Output() hideModal: EventEmitter<any>;
  //
  // constructor() {
  //   this.hideModal = new EventEmitter();
  // }
  //
  // ngOnInit(): void {
  // }
  hotel: HotelsModel = new HotelsModel();
  hotels: HotelsModel[];
  comments: HotelsComment[];
  totalStars: number;
  starList: number[] = [1, 2, 3, 4, 5];
  commentGroup: FormGroup;
  c: HotelsComment = new HotelsComment();

  constructor(private fb: FormBuilder,
              private hotelService: HotelsServiceService,
              private route: ActivatedRoute,
              private router: Router,
              private toastr: ToastrService
  ) {
    // this.hotels = this.hotelService.findAll();
  }
  // async deleteHotel(index): Promise<void> {
  //   await this.hotelService.deleteHotel(this.hotels[index]).subscribe(data => {
  //     this.hotels = data;
  //   });
  //   await this.listHotels();
  // }
  async ngOnInit(): Promise<void> {
    const hotelIndex: number = +this.route.snapshot.paramMap.get('i');
    await this.hotelService.findAll().subscribe(data => {
      this.hotels = data;
      this.hotel = this.hotels[hotelIndex];
      console.log('index vo hotel info ' + hotelIndex);
      console.log('hotel vo hotel info ' + this.hotels[hotelIndex]);
      this.totalStars = Number(this.hotel.stars);
    });
    this.hotelService.getComments(this.hotel).subscribe(data => {
      this.comments = data;
    });
    this.commentGroup = this.fb.group({
      comment: ['', [Validators.required]],
    });
    // const hotelIndex: number = +this.route.snapshot.paramMap.get('i');
    // this.hotelService.getHotel(this.hotels[hotelIndex]).subscribe((data) => {
    //   this.hotel = data;
    // });
    // console.log('index vo hotel info ' + hotelIndex);
    // console.log('hotel vo hotel info ' + this.hotels[hotelIndex]);
    // this.hotel = this.hotels[hotelIndex];
    // console.log('HOTEL INFO - NAME', hotelName);
  }

  // handleHotelDetails() {
  //   const hotelId: number = +this.route.snapshot.paramMap.get('i');
  //   console.log(hotelId);
  //   this.hotelService.getHotel(hotelId).subscribe((data) => {
  //     this.hotel = data;
  //   });
  //   console.log(this.hotel.address);
  // }

  async addComment(hotel: HotelsModel) {
    const data = this.commentGroup.getRawValue();
    this.c.comment = data;
    this.c.hotelName = hotel.name;
    await this.hotelService.addNewComment(this.c).subscribe();
    await this.router.navigate(['/hotels']);
    this.toastr.success('You successfully added a new comment!');
  }

}
