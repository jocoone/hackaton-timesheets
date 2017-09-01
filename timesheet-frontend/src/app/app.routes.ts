import { Routes } from '@angular/router';
import { LoginContainer } from './login/containers/login.container';

export const AppRoutes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginContainer}
];
