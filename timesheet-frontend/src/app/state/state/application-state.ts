import { UserState } from './UserState';
import { TimesheetState } from './TimesheetState';

export interface ApplicationState {
  user: UserState;
  timesheet: TimesheetState
}
