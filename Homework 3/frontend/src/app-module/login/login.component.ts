import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UserServiceService} from '../../services/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFG: FormGroup;
  error: string;
  constructor(private fb: FormBuilder,
              private router: Router,
              private userService: UserServiceService) {
    this.loginFG = fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }
  goToSignUp(): void {
    this.router.navigate(['./signup']);
  }

  // tslint:disable-next-line:typedef
  async login() {
    const loginDetails = this.loginFG.value;
    try {
      const token = await this.userService.login(loginDetails);
      this.error = null;
      await this.router.navigate(['/home']);
    } catch (err) {
      this.error = err.error;
    }
  }

}
