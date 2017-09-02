import {Component, Input} from "@angular/core";
import {ProjectActivity} from "../../model/ProjectActivity";

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrls: ['./project-card.component.scss']
})
export class ProjectCardComponent {

  @Input() project:ProjectActivity;

  constructor() {
  }

}
