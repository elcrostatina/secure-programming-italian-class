import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { }

  public setSessionToken(token: string): void {
    localStorage.setItem('SESSION_TOKEN', token);
  }

  public getSessionToken(): string {
    return localStorage.getItem('SESSION_TOKEN') as string;
  }
}
