import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpFG: FormGroup;
  constructor(private fb: FormBuilder,
              private router: Router) {
    this.signUpFG = fb.group({
      email: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
    });
  }

  ngOnInit(): void {
  }
  goToLogin(): void {
    this.router.navigate(['./login']);
  }

}
