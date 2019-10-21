import { Router } from '@angular/router';
import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/auth/auth.service';
import { User } from '../user';
import { PlatformDetectorService } from 'src/app/core/platform-detector/platform-detector.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  loginform: FormGroup;
  @ViewChild('userNameInput') userNameInput: ElementRef<HTMLInputElement>;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private platformDetectorService: PlatformDetectorService) { }

  ngOnInit(): void {
    this.loginform = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    const userName = this.loginform.get('username').value;
    const password = this.loginform.get('password').value;
    var id: number;

    this.authService
      .authenticate(userName, password)
      .subscribe(
        () => this.authService
          .getId(userName)
          .subscribe(
            (data: User) => {
              id = data[0].id;
              this.router.navigate(['user', id]);
        }),

        err => {
          console.log(err);
          this.loginform.reset();
          this.platformDetectorService.isPlatformBrowser() && 
            this.userNameInput.nativeElement.focus();
          alert('Invalid user name or password!');
        }
      );
  }
}