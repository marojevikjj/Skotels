import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UserServiceService} from '../../services/user-service.service';
import {UsersModel} from '../../models/users.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: UsersModel;
  loginFG: FormGroup;
  error = false;
  constructor(private fb: FormBuilder,
              private router: Router,
              private userService: UserServiceService) {
    this.loginFG = fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }
  goToSignUp(): void {
    this.router.navigate(['./signup']);
  }
  async login() {
    const loginDetails = this.loginFG.getRawValue();
    this.user = await this.userService.login(loginDetails).toPromise();
    if (this.user == null) {
      this.error = true;
      console.log('not logged in');
    } else {
      this.userService.setUser(this.user);
      await this.router.navigate(['/home']);
      this.userService.loggedIn.next(true);
    }

  }

}
