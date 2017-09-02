import { Component, Input, Pipe, PipeTransform } from '@angular/core';
import { ProjectActivity } from '../../model/ProjectActivity';
import * as moment from 'moment';
import { Activity } from '../../model/Activity';
import * as _ from 'lodash';

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

  getActivitiesOfDateAndFactor(date: Date, factor: number): number {
    if (factor) {
      const group = _.groupBy(this.projectActivity.activities, 'factor')['' + factor];
      if (group) {
        const x = group.filter(a => new Date(a.date).getDate() === date.getDate())[0];
        return x ? x.duration : 0;
      }
    }
    return 0;
  }

  getDate(num: number) {
    return moment(this.beginOfWeek).add(num, 'days').toDate();
  }
}

@Pipe({name: 'roundHours'})
export class RoundFilter implements PipeTransform {
  transform(value: number): any {
    return Math.round(value * 100) / 100;
  }

}


