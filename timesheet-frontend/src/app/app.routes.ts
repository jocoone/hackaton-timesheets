import { Routes } from '@angular/router';
import { LoginContainer } from './login/containers/login.container';
import { TimesheetContainer } from './timesheet/containers/timesheet.container';

export const AppRoutes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginContainer},
  { path: 'timesheet', component: TimesheetContainer}
];
