import { Project } from './Project';
import { Activity } from './Activity';
export class ProjectActivity {
  constructor(readonly project: Project,
              readonly activities: Array<Activity>) {}
}
