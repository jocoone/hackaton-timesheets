import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TimesheetSandbox } from './timesheet.sandbox';
import { TimesheetContainer } from './containers/timesheet.container';
import { DatepickerModule } from 'ngx-bootstrap';
import { DateSelectorComponent } from './components/date-selector/date-selector.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [TimesheetContainer, DateSelectorComponent],
  imports: [CommonModule, RouterModule, DatepickerModule.forRoot(), FormsModule],
  providers: [TimesheetSandbox]
})
export class TimesheetModule {

}
