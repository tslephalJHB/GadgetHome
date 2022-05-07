import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/userService/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(public loginService:UserService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onFormSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    this.loginService.login(this.loginForm.value['username'], this.loginForm.value['password'])
    .subscribe(response => {
      if(!response["error"]){
        localStorage.setItem('token', response["token"]);
      }

      window.alert(response["message"]);
    })
  }

}
