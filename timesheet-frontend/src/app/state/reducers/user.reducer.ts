import { UserState } from '../state/UserState';
import { Action } from '@ngrx/store';

const initialState: UserState = {
  user: null
}

export function userReducer(state: UserState = initialState, action: Action): UserState {
  switch(action.type) {
    case 'LOGIN':
      console.log(action);
      return {
        user: action.payload
      };
    default:
      return state;
  }
}
