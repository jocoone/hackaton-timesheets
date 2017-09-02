import {Component, Input} from "@angular/core";
import {ProjectActivity} from "../../model/ProjectActivity";

@Component({
  selector: 'app-timesheet-metadata',
  templateUrl: './timesheet-metadata.component.html',
  styleUrls: ['./timesheet-metadata.component.scss']
})

export class TimesheetMetaDataComponent {

  @Input() projects: Array<ProjectActivity>;

  constructor() { }

}
