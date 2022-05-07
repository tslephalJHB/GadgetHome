import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiURL = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  register(user: User): Observable<{[index: string]: any}>{
    return this.http
      .post<User>(this.apiURL + '/register', JSON.stringify(user), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  login(userName: string, password: string): Observable<{[index:string]: any}> {
    return this.http
      .post<User>(this.apiURL + '/login', JSON.stringify({"user_name": userName, "password": password}), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
