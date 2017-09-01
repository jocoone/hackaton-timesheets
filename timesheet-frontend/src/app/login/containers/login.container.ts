import { Component } from '@angular/core';
import { User } from '../../state/state/UserState';
import { Observable } from 'rxjs/Observable';
import { LoginSandbox } from '../login.sandbox';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login-container',
  templateUrl: './login.container.html',
  styleUrls: ['./login.container.scss']
})
export class LoginContainer {

  user$: Observable<User> = this.sb.user$;

  constructor(private sb: LoginSandbox,
              private route: Router) {}

  login(user: User) {
    this.sb.login(user);
    this.route.navigate(['/timesheet']);
  }
}
