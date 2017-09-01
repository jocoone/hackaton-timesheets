import { Injectable } from '@angular/core';
import { TimesheetService } from './services/timesheet.service';
import { Store } from '@ngrx/store';
import { ApplicationState } from '../state/state/application-state';

@Injectable()
export class TimesheetSandbox {

  projects$ = this.store.select(state => state.timesheet.projects);

  constructor(private store: Store<ApplicationState>,
              private timesheetService: TimesheetService) {
  }

  getProjects() {
    this.timesheetService.getProjects('samvda', 2017, 35)
      .subscribe(projects => this.store.dispatch({type: 'SET_PROJECTS', payload: projects}));
  }
}
