import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) { }
  goToLogin(): void {
    this.router.navigate(['./login']);
  }
  goToHome(): void {
    this.router.navigate(['./home']);
  }
  goToAbout(): void {
    this.router.navigate(['./about']);
  }
  goToMap(): void {
    this.router.navigate(['./map']);
  }
  goToHotels(): void {
    this.router.navigate(['./hotels']);
  }

  ngOnInit(): void {
  }

}
