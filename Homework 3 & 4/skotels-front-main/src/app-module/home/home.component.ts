import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserServiceService} from '../../services/user-service.service';
import {UsersModel} from '../../models/users.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user: UsersModel;

  constructor(private router: Router, private userService: UserServiceService) { }

  ngOnInit(): void {
    this.user = this.userService.getUser();
  }
  goToMap(): void {
    this.router.navigate(['./map']);
  }

}
