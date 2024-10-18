import { Component, ViewChild } from '@angular/core';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-sider',
  templateUrl: './sider.component.html',
  styleUrls: ['./sider.component.scss']
})
export class SiderComponent {
  @ViewChild(ConfirmModalComponent) modal!: ConfirmModalComponent;
  constructor(
    private router: Router,
    private message: NzMessageService) {
  }

  onLogoutClick(): void {
    this.modal.show();
  }

  onConfirmLogout(): void {
    //WIP: add service
    this.message.info("Logout successfully", { nzDuration: 5000 })
    this.router.navigate(['/']);
  }
}
