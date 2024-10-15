import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { IncomeService } from 'src/app/services/income/income.service';

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.scss']
})
export class IncomeComponent {
  incomes: any[] = [];
  incomeForm!: FormGroup;
  listOfCategory: any[] = ["Salary", "Freelancing", "Investments", "Stocks", "Bitcoin", "Bank Transfer", "YouTube", "Other"];
  pageIndex: number = 1;
  pageSize: number = 10;
  total: number = 0;

  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private incomeService: IncomeService,
    private router: Router) { }

  ngOnInit() {
    this.getAllIncomes(this.pageIndex);
    this.incomeForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    });
  }

  submitForm() {
    this.incomeService.postIncome(this.incomeForm.value).subscribe(res => {
      this.message.success("Income posted successfully", { nzDuration: 5000 })
      this.getAllIncomes(this.pageIndex);
    }, error => {
      this.message.error("Error while posting income", { nzDuration: 5000 });
    });
  }

  getAllIncomes(page: number) {
    this.incomeService.getAllIncomes(page - 1).subscribe(res => {
      this.incomes = res.content;
      this.total = res.totalElements;
    }, error => {
      this.message.error("Error while getting all incomes", { nzDuration: 5000 });
    });
  }

  updateIncome(id: number) {
    this.router.navigateByUrl(`/income/${id}/edit`);
  }

  deleteIncome(id: number) {
    this.incomeService.deleteIncome(id).subscribe(res => {
      this.message.success("Income deleted successfully", { nzDuration: 5000 });
      this.getAllIncomes(this.pageIndex);
    }, error => {
      this.message.error("Error while deleting income", { nzDuration: 5000 });
    });
  }

  onPageIndexChange(pageIndex: number) {
    this.pageIndex = pageIndex;
    this.getAllIncomes(pageIndex);
  }
}
