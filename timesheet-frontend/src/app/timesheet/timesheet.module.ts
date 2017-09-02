import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TimesheetSandbox } from './timesheet.sandbox';
import { TimesheetContainer } from './containers/timesheet.container';
import { DatepickerModule } from 'ngx-bootstrap';
import { DateSelectorComponent } from './components/date-selector/date-selector.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { TimesheetDataComponent, TimesheetDataFilter } from './components/timesheet-data/timesheet-data.component';
import { TimesheetService } from './services/timesheet.service';
import { ProjectActivityDataComponent, RoundFilter } from './components/project-activity-data/project-activity-data.component';
import { HourCardComponent } from './components/hour-card/hour-card.component';
import { ProjectCardComponent } from './components/project-card/project-card.component';
import { TimesheetMetaDataComponent } from './components/timesheet-metadata/timesheet-metadata.component';

@NgModule({
  declarations: [TimesheetContainer, DateSelectorComponent, TimesheetDataComponent, ProjectActivityDataComponent,
    TimesheetDataFilter, HourCardComponent, ProjectCardComponent, TimesheetMetaDataComponent, RoundFilter],
  imports: [CommonModule, RouterModule, DatepickerModule.forRoot(), FormsModule, HttpModule],
  providers: [TimesheetSandbox, TimesheetService]
})
export class TimesheetModule {

}
