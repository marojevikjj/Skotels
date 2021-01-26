import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserServiceService} from '../../services/user-service.service';
import {UsersModel} from '../../models/users.model';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loggedIn: boolean = false;
  constructor(private router: Router, private userService: UserServiceService) { }
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

  async ngOnInit(): Promise<void> {
    this.userService.loggedIn.subscribe(res => {
      this.loggedIn = res;
    });
  }

  async logOut(): Promise<void> {
    await this.userService.logout().toPromise();
    this.userService.setUser(null);
    await this.router.navigate(['./login']);
    this.userService.loggedIn.next(false);
  }

}
