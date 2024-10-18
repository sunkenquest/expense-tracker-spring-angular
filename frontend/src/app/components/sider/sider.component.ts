import { Component, ViewChild } from '@angular/core';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sider',
  templateUrl: './sider.component.html',
  styleUrls: ['./sider.component.scss']
})
export class SiderComponent {
  @ViewChild(ConfirmModalComponent) modal!: ConfirmModalComponent;
  constructor(
    private router: Router) {
  }

  onLogoutClick(): void {
    this.modal.show();
  }

  onConfirmLogout(): void {
    this.router.navigate(['/']);
  }
}
