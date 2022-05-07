import { User } from '../app/models/user';

let user: User = new User("tshiamo", "Tshiamo", "Lephale", "tshiamo.lephale@gmail.com", "0632170392", "password");

export function mockRegisterSuccess(user:User): {[index: string]: any} {
  return {
    "error": false,
    "message": "Account created successfully",
    "username": user.user_name,
    "user": user,
    "token": "1234567890"
  }
}

export function mockLoginSuccess(username:string, password:string): {[index: string]: any} {
  return {
    "error": false,
    "message": "Logged In",
    "username": username,
    "user": user,
    "token": "1234567890"
  }
}
