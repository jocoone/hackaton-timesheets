import { Component, Input } from '@angular/core';
import { ProjectActivity } from '../../model/ProjectActivity';
@Component({
  selector: 'app-project-activity-data',
  templateUrl: './project-activity-data.component.html',
  styleUrls: ['./project-activity-data.component.scss']
})
export class ProjectActivityDataComponent {

  @Input()
  projectActivity: ProjectActivity;
}
