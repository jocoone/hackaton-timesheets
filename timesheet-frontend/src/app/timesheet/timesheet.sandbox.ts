import { Injectable } from '@angular/core';
import { TimesheetService } from './services/timesheet.service';
import { Store } from '@ngrx/store';
import { ApplicationState } from '../state/state/application-state';

@Injectable()
export class TimesheetSandbox {

  projects$ = this.store.select(state => state.timesheet.projects);
  user$ = this.store.select(state => state.user.user);

  constructor(private store: Store<ApplicationState>,
              private timesheetService: TimesheetService) {}

  getProjects(username: string) {
    this.timesheetService.getProjects(username, 2017, 35)
      .subscribe(projects => this.store.dispatch({type: 'SET_PROJECTS', payload: projects}));
  }
}
