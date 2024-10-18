import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  isRootRoute: boolean = false;

  constructor(private router: Router) { }
  ngOnInit(): void {
    this.router.events.subscribe(() => {
      this.isRootRoute = this.router.url === '/'
    })
  }
  title = 'frontend';
}
