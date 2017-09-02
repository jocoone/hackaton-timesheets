import {Component, Input, OnInit} from "@angular/core";
import {Activity} from "../../model/Activity";

@Component({
  selector: 'app-hour-card',
  templateUrl: './hour-card.component.html',
  styleUrls: ['./hour-card.component.scss']
})
export class HourCardComponent implements OnInit {

  @Input() activity: Activity;
  type;

  ngOnInit(): void {
    switch (this.activity.factor) {
      case 100:
        this.type = "Regular hours";
        break;
      case 150:
        this.type = "Extra hours";
        break;
      case 200:
        this.type = "Double hours";
        break;
      case undefined:
        this.type = "Non Billable";
        break;
      default:
        this.type = "fjdkslqmfj";
        break;
    }
  }

  setTypeColor() {
    let color;

    switch (this.activity.factor) {
      case 100:
        color = "type-color regular-color";
        break;
      case 150:
        color = "type-color extra-color";
        break;
      case 200:
        color = "type-color double-color";
        break;
      case undefined:
        color = "type-color nonbillable-color";
        break;
      default:
        color = "fjdkslqmfj";
        break;
    }

    return color;
  }

}
