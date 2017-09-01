import { Injectable } from '@angular/core';
import { TimesheetService } from './services/timesheet.service';
import { Store } from '@ngrx/store';
import { ApplicationState } from '../state/state/application-state';
import * as moment from 'moment';

@Injectable()
export class TimesheetSandbox {

  projects$ = this.store.select(state => state.timesheet.projects);
  projectActivities$ = this.store.select(state => state.timesheet.activities);
  user$ = this.store.select(state => state.user.user);

  constructor(private store: Store<ApplicationState>,
              private timesheetService: TimesheetService) {}

  getProjects(username: string, beginOfWeek: Date) {
    this.timesheetService.getProjects(username, beginOfWeek.getFullYear(), moment(beginOfWeek).isoWeeks())
      .subscribe(projects => this.store.dispatch({type: 'SET_PROJECTS', payload: projects}));
  }

  getActivities(username: string, beginOfWeek: Date) {
    this.timesheetService.getActivities(username, beginOfWeek.getFullYear(), moment(beginOfWeek).isoWeeks())
      .subscribe(activities => this.store.dispatch({type: 'SET_ACTIVITIES', payload: activities}));
  }
}
