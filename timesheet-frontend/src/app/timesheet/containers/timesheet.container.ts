import { Component } from '@angular/core';
import { TimesheetSandbox } from '../timesheet.sandbox';

@Component({
  selector: 'app-timesheet-container',
  templateUrl: './timesheet.container.html',
  styleUrls: ['./timesheet.container.scss']
})
export class TimesheetContainer {

  constructor(private sb: TimesheetSandbox) {}
}
