import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SessionService} from "./session.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jwt-fe';

  constructor(private readonly httpClient: HttpClient, private readonly sessionService: SessionService) { }

  public getInfo(): void {
    this.httpClient.get('http://localhost:8080/protected', {
      headers: {
        Authorization: `Bearer ${this.sessionService.getSessionToken()}`
      }
    })
      .subscribe((res) => {
      console.log(res);
    });
  }

}
