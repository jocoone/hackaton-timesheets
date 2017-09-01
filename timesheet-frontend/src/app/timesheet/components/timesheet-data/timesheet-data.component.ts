import { Component, Input } from '@angular/core';
import { Project } from '../../model/Project';

@Component({
  selector: 'app-timesheet-data',
  templateUrl: './timesheet-data.component.html',
  styleUrls: ['./timesheet-data.component.scss']
})
export class TimesheetDataComponent {

  @Input()
  projects: Array<Project>;
}
