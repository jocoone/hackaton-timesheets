import { Component } from '@angular/core';
import { User } from '../../state/state/UserState';
import { Observable } from 'rxjs/Observable';
import { LoginSandbox } from '../login.sandbox';

@Component({
  selector: 'app-login-container',
  templateUrl: './login.container.html',
  styleUrls: ['./login.container.scss']
})
export class LoginContainer {

  user$: Observable<User> = this.sb.user$;

  constructor(private sb: LoginSandbox) {}

  login(user: User) {
    this.sb.login(user);
  }
}
