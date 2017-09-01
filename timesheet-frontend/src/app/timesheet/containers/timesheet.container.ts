import { Component } from '@angular/core';
import { TimesheetSandbox } from '../timesheet.sandbox';
import { Observable } from 'rxjs/Observable';
import { Project } from '../model/Project';

@Component({
  selector: 'app-timesheet-container',
  templateUrl: './timesheet.container.html',
  styleUrls: ['./timesheet.container.scss']
})
export class TimesheetContainer {

  $projects: Observable<Array<Project>> = this.sb.projects$;

  constructor(private sb: TimesheetSandbox) {
    this.sb.getProjects();
  }
}
