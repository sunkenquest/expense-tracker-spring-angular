import { Component } from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm!: FormGroup;

  constructor(
    private fb: NonNullableFormBuilder,
    private loginService: LoginService,
    private message: NzMessageService,
    private router: Router
  ) { }


  ngOnInit() {
    this.loginForm = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
      remember: [false, Validators.required],
    })
  }

  submitForm() {
    console.log(this.loginForm.value);
    this.loginService.postLogin(this.loginForm.value).subscribe(res => {
      this.message.success("Login successfully", { nzDuration: 5000 })
      this.router.navigate(['/dashboard']);
    }, error => {
      this.message.error("Error while logging in", { nzDuration: 5000 })
    })
  }

  navigateToRegister(): void {
    this.router.navigate(['/register']);
  }
}