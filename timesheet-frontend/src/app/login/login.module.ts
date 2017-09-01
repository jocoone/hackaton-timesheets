import { NgModule } from '@angular/core';
import { LoginContainer } from './containers/login.container';
import { LoginComponent } from './components/login/login.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginSandbox } from './login.sandbox';

@NgModule({
  declarations: [LoginContainer, LoginComponent],
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  providers: [LoginSandbox]
})
export class LoginModule {

}
