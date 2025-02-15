import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor(private http: HttpClient) { }

  postExpense(expenseDto: any): Observable<any> {
    return this.http.post(BASIC_URL + "api/auth/expense", expenseDto)
  }

  getAllExpenses(page: number, sort: string): Observable<any> {
    return this.http.get(BASIC_URL + `api/auth/expense/all?page=${page}&sort=${sort}`)
  }

  deleteExpense(id: number): Observable<any> {
    return this.http.delete(BASIC_URL + `api/auth/expense/${id}`)
  }

  getExpenseId(id: number): Observable<any> {
    return this.http.get(BASIC_URL + `api/auth/expense/${id}`)
  }

  updateExpense(id: number, expenseDto: any): Observable<any> {
    return this.http.put(BASIC_URL + `api/auth/expense/${id}`, expenseDto
    )
  }
}
