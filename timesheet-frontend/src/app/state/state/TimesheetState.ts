import { Project } from '../../timesheet/model/Project';
import { ProjectActivity } from '../../timesheet/model/ProjectActivity';

export interface TimesheetState {
  projects: Array<Project>;
  activities: Array<ProjectActivity>;
}
