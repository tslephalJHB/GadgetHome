import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../../models/user';
import { UserService } from '../../services/userService/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm!: FormGroup;

  constructor(public registerService: UserService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      name: ['', Validators.required],
      last: ['', Validators.required],
      email: ['', Validators.required],
      number: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onFormSubmit() {
    if (this.registerForm.invalid) {
      return;
    }

    let registerUser = new User(this.registerForm.value['username'],
      this.registerForm.value['name'],
      this.registerForm.value['last'],
      this.registerForm.value['email'],
      this.registerForm.value['number'],
      this.registerForm.value['password']);

    this.registerService.register(registerUser).subscribe(response => {
      if(!response["error"]){
        localStorage.setItem('token', response["token"]);
      }

      window.alert(response["message"]);
    })
  }


}
