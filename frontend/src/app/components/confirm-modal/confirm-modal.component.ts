import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-modal',
  template: `
    <nz-modal
      [(nzVisible)]="isVisible"
      [nzTitle]="title"
      (nzOnCancel)="handleCancel()"
      (nzOnOk)="handleOk()"
    >
      <ng-container *nzModalContent>
        <p>{{ message }}</p>
      </ng-container>
    </nz-modal>
  `
})
export class ConfirmModalComponent {
  isVisible = false;

  @Input() title: string;
  @Input() message: string;

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
