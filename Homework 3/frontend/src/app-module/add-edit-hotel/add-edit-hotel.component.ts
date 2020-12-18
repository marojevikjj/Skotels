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
      fax: ['', []],
      address: ['', []],
      city: ['', []],
      phone: ['', []],
      website: ['', []],
      stars: ['', []],
      internetAccess: ['', []],
      rooms: ['', []],
      latitude: ['', []],
      longitude: ['', []],
    });
  }

  ngOnInit(): void {
  }
  discard(): void {
    this.router.navigate(['/hotels']);
  }
  async submitHotel() {
    const data = this.hotelsFG.getRawValue();
    await this.hotelService.add(data).subscribe();
    await this.router.navigate(['/hotels']);
    this.toastr.success('You successfully added a hotel!');
  }

}
