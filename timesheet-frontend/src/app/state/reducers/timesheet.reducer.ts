import { Action } from '@ngrx/store';
import { TimesheetState } from '../state/TimesheetState';

const initialState: TimesheetState = {
  projects: [],
  activities: []
}

export function timesheetReducer(state: TimesheetState = initialState, action: Action): TimesheetState {
  switch(action.type) {
    case 'SET_PROJECTS':
      return {
        projects: action.payload,
        activities: state.activities
      };
    case 'SET_ACTIVITIES':
      return {
        projects: state.projects,
        activities: action.payload
      };
    default:
      return state;
  }
}
