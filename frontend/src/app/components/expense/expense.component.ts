import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ExpenseService } from 'src/app/services/expense/expense.service';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.scss']
})
export class ExpenseComponent {
  expenseForm!: FormGroup;
  listOfCategory: any[] = [
    "Food",
    "Education",
    "Groceries",
    "Health",
    "Subcriptions",
    "Takeaways",
    "Clothing",
    "Travelling",
    "Other",
  ]

  pageIndex: number = 1;
  pageSize: number = 10;
  total: number = 0;
  sort: string = "asc";
  expenses: any;

  constructor(
    private fb: FormBuilder,
    private expenseService: ExpenseService,
    private message: NzMessageService,
    private router: Router) {
  }

  ngOnInit() {
    this.getAllExpenses(this.pageIndex, this.sort);
    this.expenseForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    })
  }

  submitForm() {
    this.expenseService.postExpense(this.expenseForm.value).subscribe(res => {
      this.message.success("Expense posted successfully", { nzDuration: 5000 });
      this.getAllExpenses(this.pageIndex, this.sort);
    }, error => {
      this.message.error("Error while posting expense", { nzDuration: 5000 });
    });
  }

  getAllExpenses(page: number, sort: string) {
    this.pageIndex = page;
    this.sort = sort;
    this.expenseService.getAllExpenses(page - 1, sort).subscribe(res => {
      this.expenses = res.content;
      this.total = res.totalElements;
    });
  }

  updateExpense(id: number) {
    this.router.navigateByUrl(`/expense/${id}/edit`);
  }

  deleteExpense(id: number) {
    this.expenseService.deleteExpense(id).subscribe(res => {
      this.message.success("Expense deleted successfully", { nzDuration: 5000 });
      this.getAllExpenses(this.pageIndex, this.sort);
    }, error => {
      this.message.error("Error while deleting expense", { nzDuration: 5000 });
    });
  }

  onPageIndexChange(pageIndex: number, sort: string | null) {
    this.pageIndex = pageIndex;
    if (sort == null) {
      sort = this.sort;
    }

    this.getAllExpenses(pageIndex, sort);
  }
}