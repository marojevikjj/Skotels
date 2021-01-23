import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { DomSanitizer, SafeResourceUrl, SafeUrl, SafeHtml} from '@angular/platform-browser';
// import {DomSanitizationService} from '@angular/platform-browser';

@Component({
  selector: 'app-hotel-map',
  templateUrl: './hotel-map.component.html',
  styleUrls: ['./hotel-map.component.css'],
})
export class HotelMapComponent implements OnInit {
  @Input() location: any;
  @Output() hideModal: EventEmitter<any>;
  test: any;

  constructor(private dom: DomSanitizer) {
    this.hideModal = new EventEmitter();
    // this.test = this.dom.bypassSecurityTrustResourceUrl(this.location);
  }

  ngOnInit(): void {

  }
  closeModal(): void {
    this.hideModal.emit();
  }
  getSafeUrl() {
    console.log('Location at show map:', this.location);
    return this.dom.bypassSecurityTrustResourceUrl(this.location);
  }

}
