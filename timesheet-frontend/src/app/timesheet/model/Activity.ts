import { Project } from './Project';

export class Activity {
  constructor(readonly id: number,
              readonly type: any,
              readonly duration: number,
              readonly project: Project) {}
}
