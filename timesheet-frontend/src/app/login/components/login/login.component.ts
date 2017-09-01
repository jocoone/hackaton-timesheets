import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../../state/state/UserState';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  @Output()
  login: EventEmitter<User> = new EventEmitter();

  loginForm = new FormGroup ({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  loginUser(user: User) {
    this.login.emit(new User(user.username, user.password));
  }
}
