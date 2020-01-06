import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  private signin: boolean;

  constructor(private router: Router) { }

  ngOnInit(): void {
    if (window.location.href != 'http://localhost:4200/' && window.location.href != 'http://localhost:4200/signup') {
      this.signin = true;
    }
  }
}

