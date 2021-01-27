import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
  lat = 41.9964832;
  lng = 21.43043000;
  constructor() { }

  ngOnInit(): void {
  }

}
