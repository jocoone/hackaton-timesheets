import { Component, Input } from '@angular/core';
import { ProjectActivity } from '../../model/ProjectActivity';
import * as moment from 'moment';

@Component({
  selector: 'app-project-activity-data',
  templateUrl: './project-activity-data.component.html',
  styleUrls: ['./project-activity-data.component.scss']
})
export class ProjectActivityDataComponent {

  @Input()
  projectActivity: ProjectActivity;

  @Input()
  beginOfWeek: Date;

  getActivities() {
    console.log(this.beginOfWeek);
    console.log(this.projectActivity.activities);
    return this.projectActivity.activities
      .filter(a => moment(this.beginOfWeek).endOf('isoWeek').isAfter(moment(new Date(a.date)))
        && moment(new Date(a.date)).isAfter(moment(this.beginOfWeek)));
  }
}


