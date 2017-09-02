import { Component } from '@angular/core';
import { TimesheetSandbox } from '../timesheet.sandbox';
import { Observable } from 'rxjs/Observable';
import { Project } from '../model/Project';
import { Router } from '@angular/router';
import { ProjectActivity } from '../model/ProjectActivity';

@Component({
  selector: 'app-timesheet-container',
  templateUrl: './timesheet.container.html',
  styleUrls: ['./timesheet.container.scss']
})
export class TimesheetContainer {

  projectActivities$: Observable<Array<ProjectActivity>> = this.sb.projectActivities$;
  beginOfWeek: Date;

  constructor(private sb: TimesheetSandbox,
              private route: Router) {}

  selectedWeek(selectedWeek) {
    this.beginOfWeek = selectedWeek.start;
    this.sb.user$.subscribe(user => {
      if (!user) {
        this.route.navigate(['/login']);
      } else {
        // this.sb.getProjects(user.username, selectedWeek.start);
        this.sb.getActivities(user.username, selectedWeek.start);
      }
    });
  }
}
