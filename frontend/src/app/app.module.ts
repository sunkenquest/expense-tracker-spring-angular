import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemoNgZorroAntModule } from './DemoNgZorroAntModule';
import { ExpenseComponent } from './components/expense/expense.component';
import { UpdateExpenseComponent } from './components/update-expense/update-expense.component';
import { IncomeComponent } from './components/income/income.component';
import { UpdateIncomeComponent } from './components/update-income/update-income.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    ExpenseComponent,
    UpdateExpenseComponent,
    IncomeComponent,
    UpdateIncomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DemoNgZorroAntModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
