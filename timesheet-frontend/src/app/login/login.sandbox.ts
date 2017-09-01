
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from '../state/state/UserState';
import { Store } from '@ngrx/store';
import { ApplicationState } from '../state/state/application-state';

@Injectable()
export class LoginSandbox {

  user$: Observable<User> = this.store.select(state => state.user.user);

  constructor(private store: Store<ApplicationState>) {}

  login(user: User) {
    this.store.dispatch({type: 'LOGIN', payload: user});
  }
}
