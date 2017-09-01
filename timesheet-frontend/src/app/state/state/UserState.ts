export interface UserState {
  user: User
}

export class User {
  constructor(readonly username: string,
              readonly password: string) {}
}
