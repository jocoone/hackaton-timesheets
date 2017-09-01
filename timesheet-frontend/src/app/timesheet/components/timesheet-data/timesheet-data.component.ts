import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { Project } from '../../model/Project';
import { ProjectActivity } from '../../model/ProjectActivity';

@Component({
  selector: 'app-timesheet-data',
  templateUrl: './timesheet-data.component.html',
  styleUrls: ['./timesheet-data.component.scss']
})
export class TimesheetDataComponent {

  @Input()
  projectActivities: Array<ProjectActivity>;
}
