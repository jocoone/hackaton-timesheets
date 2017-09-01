import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TimesheetSandbox } from './timesheet.sandbox';
import { TimesheetContainer } from './containers/timesheet.container';
import { DatepickerModule } from 'ngx-bootstrap';
import { DateSelectorComponent } from './components/date-selector/date-selector.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { TimesheetDataComponent } from './components/timesheet-data/timesheet-data.component';
import { TimesheetService } from './services/timesheet.service';
import { ProjectActivityDataComponent } from './components/project-activity-data/project-activity-data.component';

@NgModule({
  declarations: [TimesheetContainer, DateSelectorComponent, TimesheetDataComponent, ProjectActivityDataComponent],
  imports: [CommonModule, RouterModule, DatepickerModule.forRoot(), FormsModule, HttpModule],
  providers: [TimesheetSandbox, TimesheetService]
})
export class TimesheetModule {

}
