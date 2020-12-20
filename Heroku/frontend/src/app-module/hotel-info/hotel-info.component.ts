import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-hotel-info',
  templateUrl: './hotel-info.component.html',
  styleUrls: ['./hotel-info.component.css']
})
export class HotelInfoComponent implements OnInit {
  @Input() hotel: any;
  @Output() hideModal: EventEmitter<any>;

  constructor() {
    this.hideModal = new EventEmitter();
  }

  ngOnInit(): void {
  }

  closeModal(): void {
    this.hideModal.emit();

  }

}
