import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UsersModel} from '../../models/users.model';
import {UserServiceService} from '../../services/user-service.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: UsersModel;
  signUpFG: FormGroup;
  constructor(private fb: FormBuilder,
              private router: Router,
              private userService: UserServiceService) {
    this.signUpFG = fb.group({
      email: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
    });
  }
  onSubmit(): void {
    this.userService.register(this.user).subscribe(result => this.goToLogin());
  }

  ngOnInit(): void {
  }
  goToLogin(): void {
    this.router.navigate(['./login']);
  }

}
