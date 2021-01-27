import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { DomSanitizer, SafeResourceUrl, SafeUrl, SafeHtml} from '@angular/platform-browser';

@Component({
  selector: 'app-hotel-map',
  templateUrl: './hotel-map.component.html',
  styleUrls: ['./hotel-map.component.css'],
})
export class HotelMapComponent implements OnInit {
  @Input() location: any;
  @Output() hideModal: EventEmitter<any>;

  constructor(private dom: DomSanitizer) {
    this.hideModal = new EventEmitter();
  }

  ngOnInit(): void {

  }
  closeModal(): void {
    this.hideModal.emit();
  }
  getSafeUrl() {
    return this.dom.bypassSecurityTrustResourceUrl(this.location);
  }

}
