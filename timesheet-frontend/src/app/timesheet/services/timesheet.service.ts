import { Injectable } from '@angular/core';
import { Http, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ProjectActivity } from '../model/ProjectActivity';
import { Activity } from '../model/Activity';
import * as _ from 'lodash';

@Injectable()
export class TimesheetService {

  constructor(private http: Http) {}

  getProjects(username: string, year: number, week: number) {
    const params: URLSearchParams = new URLSearchParams();
    params.set('year', '' + year);
    params.set('weekNumber', '' + week);
    params.set('username', username);
    return this.http.get('http://localhost:8080/projects', {search: params})
      .map(response => response.json());
  }

  getActivities(username: string, year: number, week: number): Observable<Array<ProjectActivity>> {
    const params: URLSearchParams = new URLSearchParams();
    params.set('year', '' + year);
    params.set('weekNr', '' + week);
    params.set('username', username);
    return this.http.get('http://localhost:8080/activities', {search: params})
      .map(response => response.json())
      .map((activities: Array<Activity>) => {
        const groupedActivities = _.groupBy(activities, (activity: Activity) => activity.project ? activity.project.id : 'nb');
        const result = [];
        _.keys(groupedActivities).forEach((project) => {
          result.push(new ProjectActivity(groupedActivities[project][0].project, groupedActivities[project]));
        });
        return result;
      });
  }
}
