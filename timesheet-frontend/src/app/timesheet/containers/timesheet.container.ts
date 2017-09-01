import { Component } from '@angular/core';
import { TimesheetSandbox } from '../timesheet.sandbox';
import { Observable } from 'rxjs/Observable';
import { Project } from '../model/Project';
import { Router } from '@angular/router';

@Component({
  selector: 'app-timesheet-container',
  templateUrl: './timesheet.container.html',
  styleUrls: ['./timesheet.container.scss']
})
export class TimesheetContainer {

  $projects: Observable<Array<Project>> = this.sb.projects$;

  constructor(private sb: TimesheetSandbox,
              private route: Router) {
    this.sb.user$.subscribe(user => {
      console.log(user);
      if (!user) {
        this.route.navigate(['/login']);
      } else {
        this.sb.getProjects(user.username);
      }
    })
  }
}
