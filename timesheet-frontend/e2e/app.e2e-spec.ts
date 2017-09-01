import { HackatonTimesheetPage } from './app.po';

describe('hackaton-timesheet App', () => {
  let page: HackatonTimesheetPage;

  beforeEach(() => {
    page = new HackatonTimesheetPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
