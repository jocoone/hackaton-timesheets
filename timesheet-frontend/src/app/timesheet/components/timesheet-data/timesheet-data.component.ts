import { Component, Input, Pipe, PipeTransform } from '@angular/core';
import { ProjectActivity } from '../../model/ProjectActivity';
import * as _ from 'lodash';

@Component({
  selector: 'app-timesheet-data',
  templateUrl: './timesheet-data.component.html',
  styleUrls: ['./timesheet-data.component.scss']
})
export class TimesheetDataComponent {

  @Input()
  projectActivities: Array<ProjectActivity>;
}

@Pipe({ name: 'timesheetFilter'})
export class TimesheetDataFilter implements PipeTransform {
  transform(value: Array<ProjectActivity>): Array<ProjectActivity> {
    return value.filter(pa => !!pa.project);
  }

}
