import { Action } from '@ngrx/store';
import { TimesheetState } from '../state/TimesheetState';

const initialState: TimesheetState = {
  projects: []
}

export function timesheetReducer(state: TimesheetState = initialState, action: Action): TimesheetState {
  switch(action.type) {
    case 'SET_PROJECTS':
      return {
        projects: action.payload
      };
    default:
      return state;
  }
}
