import { Injectable } from '@angular/core';
import { TimesheetService } from './services/timesheet.service';

@Injectable()
export class TimesheetSandbox {

  constructor(private timesheetService: TimesheetService) {
  }

  getProjects() {
    this.timesheetService.getProjects('samvda', 2017, 35)
      .subscribe(projects => console.log(projects));
  }
}
