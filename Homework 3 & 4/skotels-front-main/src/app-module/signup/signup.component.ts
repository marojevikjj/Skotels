import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UsersModel} from '../../models/users.model';
import {UserServiceService} from '../../services/user-service.service';
import {ToastrService} from 'ngx-toastr';
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
              private userService: UserServiceService,
              private toastr: ToastrService) {
    this.signUpFG = fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
    },
        {validator: this.passwordMatchValidator}
    );
  }
  passwordMatchValidator(frm: FormGroup) {
    return frm.controls['password'].value === frm.controls['repeatPassword'].value ? null : {'mismatch': true};
  }
  onSubmit(): void {
    const data = this.signUpFG.getRawValue();
    this.userService.register(data).subscribe(result => {
      this.toastr.success('You have successfully created a user');
      this.goToLogin();
    });
  }

  ngOnInit(): void {
  }
  goToLogin(): void {
    this.router.navigate(['./login']);
  }


}
