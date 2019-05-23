import { Component } from '@angular/core';
import { Router, ActivatedRoute, NavigationExtras  } from '@angular/router';
import {GuestBookService} from '../guestbook.service';
import { UserCredentials } from '../usercredentials';
import { UserInfoReq } from '../userInfoReq';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html'
})
export class LoginComponent{
  userType;
  public loginInfo = {};
  message;
  userInfo: UserInfoReq = new UserInfoReq();
  usercredentials: UserCredentials = new UserCredentials();
 
  constructor(private route: ActivatedRoute,
  private router: Router,
  private guestBookService: GuestBookService){}

    ngOnInit() {
    this.userType=this.route.snapshot.params['userType'];
}

        login(usercredentials){
          if(!(usercredentials.userName === undefined) || !(usercredentials.password === undefined)){
            if(this.userType == 'user'){
            this.guestBookService.validateUser(usercredentials)
            .subscribe(data => {this.userInfo = data;
            this.userInfo.validationMsg = data.validationMsg;
            this.userInfo.userName = data.userName;
            this.userInfo.guestBook = data.guestBook;
            this.message = this.userInfo.validationMsg;
            });
                               
             }else {
              if(usercredentials.userName == 'Admin' && usercredentials.password == 'Admin1'){
            this.router.navigateByUrl('/admin');
              }else{
              this.message='Username and Password did not match';
              }
           }
          }else{
            this.message='Username and Password cannot be blank';
          }
        }

      signup(){
        this.router.navigateByUrl('/signup');
      }
  
}