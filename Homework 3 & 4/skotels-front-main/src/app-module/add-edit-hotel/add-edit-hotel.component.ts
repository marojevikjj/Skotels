import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {HotelsServiceService} from '../../services/hotels-service.service';

@Component({
  selector: 'app-add-edit-hotel',
  templateUrl: './add-edit-hotel.component.html',
  styleUrls: ['./add-edit-hotel.component.css']
})
export class AddEditHotelComponent implements OnInit {
  hotelsFG: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private hotelService: HotelsServiceService,
              private toastr: ToastrService) {
    this.hotelsFG = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', []],
      location: ['', [Validators.required]],
      addrStreet: ['', [Validators.required]],
      internetAccess: ['', []],
      rooms: ['', []],
      phone: ['', []],
      website: ['', []],
      stars: ['', [Validators.required]],
      latitude: ['', []],
      longitude: ['', []],
    });
  }

  ngOnInit(): void {
  }
  discard(): void {
    this.router.navigate(['/hotels']);
  }
  // tslint:disable-next-line:typedef
  async submitHotel() {
    const data = this.hotelsFG.getRawValue();
    await this.hotelService.add(data).subscribe();
    await this.router.navigate(['/hotels']);
    this.toastr.success('You successfully added a hotel!');
  }

}
