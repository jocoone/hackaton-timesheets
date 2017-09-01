import { Injectable } from '@angular/core';
import { Http, URLSearchParams } from '@angular/http';

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
}
