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
  incomes: any;
  incomeForm!: FormGroup;
  listOfCategory: any[] = ["Salary", "Freelancing", "Investments", "Stocks", "Bitcoin", "Bank Transfer", "YouTube", "Other"];

  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private incomeService: IncomeService,
    private router: Router) { }

  ngOnInit() {
    this.getAllIncomes()
    this.incomeForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    })
  }

  submitForm() {
    this.incomeService.postIncome(this.incomeForm.value).subscribe(res => {
      this.message.success("Income posted successfully", { nzDuration: 5000 })
      this.getAllIncomes();
    }, error => {
      this.message.error("Error while posting expense", { nzDuration: 5000 })
    })
  }

  getAllIncomes() {
    this.incomeService.getAllIncomes().subscribe(res => {
      this.incomes = res
    }, error => {
      this.message.error("Error while getting all income", { nzDuration: 5000 })
    })
  }
}
