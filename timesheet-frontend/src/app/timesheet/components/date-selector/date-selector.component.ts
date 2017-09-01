import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-date-selector',
  templateUrl: './date-selector.component.html',
  styleUrls: ['./date-selector.component.scss']
})
export class DateSelectorComponent implements OnInit {

  @Output() selectedWeek = new EventEmitter();

  beginOfMonth = new Date();
  weeks = this.getWeeksInMonth(this.beginOfMonth);
  week = this.weeks[0];

  ngOnInit() {
    this.selectedWeek.emit(this.weeks[0]);
  }

  dateChanged(beginOfMonth: any) {
    this.weeks = this.getWeeksInMonth(beginOfMonth);
  }

  getWeeksInMonth(beginOfMonth) {
    const weeks = [];

    let beginOfWeek = moment(beginOfMonth).startOf('isoWeek').toDate();
    let endOfWeek = moment(beginOfMonth).endOf('isoWeek').toDate();
    while (endOfWeek.getMonth() === beginOfMonth.getMonth()) {
      weeks.push({
        start: beginOfWeek,
        end: endOfWeek
      });
      beginOfWeek = moment(beginOfWeek).add(1, 'weeks').toDate();
      endOfWeek = moment(beginOfWeek).endOf('isoWeek').toDate();
    }
    weeks.push({
      start: beginOfWeek,
      end: endOfWeek
    })

    return weeks;
  }

  selectWeek(week: Week) {
    this.selectedWeek.emit(week);
    this.week = week;
  }
}

class Week {
  constructor(readonly start: Date, readonly end: Date) {}
}
