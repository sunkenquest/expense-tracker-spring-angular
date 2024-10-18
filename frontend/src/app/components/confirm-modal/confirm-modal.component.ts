// confirmation-modal.component.ts
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-modal',
  template: `
    <nz-modal
      [(nzVisible)]="isVisible"
      nzTitle="Confirm Logout"
      (nzOnCancel)="handleCancel()"
      (nzOnOk)="handleOk()"
    >
      <ng-container *nzModalContent>
        <p>Are you sure you want to logout?</p>
      </ng-container>
    </nz-modal>
  `
})
export class ConfirmModalComponent {
  isVisible = false;
  @Output() confirm = new EventEmitter<void>();

  show(): void {
    this.isVisible = true;
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  handleOk(): void {
    this.isVisible = false;
    this.confirm.emit();
  }
}
