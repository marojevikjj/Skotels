import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFG: FormGroup;
  error: string;
  userFG: FormGroup;

  constructor(private fb: FormBuilder,
              private router: Router) {
    this.loginFG = fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.userFG = fb.group({
      user: ['', Validators.required],
      admin: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }
  goToSignUp(): void {
    this.router.navigate(['./signup']);
  }

}
