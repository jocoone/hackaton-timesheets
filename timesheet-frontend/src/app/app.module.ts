import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { PreloadAllModules, RouterModule } from '@angular/router';
import { AppRoutes } from './app.routes';
import { LoginModule } from './login/login.module';
import { StoreModule } from '@ngrx/store';
import { rootReducer } from './state/root.reducer';
import { TimesheetModule } from './timesheet/timesheet.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, CommonModule, RouterModule.forRoot(AppRoutes, {preloadingStrategy: PreloadAllModules}),


    StoreModule.provideStore(rootReducer),

    LoginModule, TimesheetModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
