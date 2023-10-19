import {AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import {Route} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
public ourValues= "ciao"
  constructor() {
  }

  public userInput = '<script>alert("hello")</script>';

  ngAfterViewInit(): void {
  }
}
