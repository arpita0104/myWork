import { Component } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GuestBookService } from '../guestbook.service';
import { UserCredentials } from '../usercredentials';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html'
})

export class SignUpComponent{
    usercredentials: UserCredentials = new UserCredentials();
    constructor(private guestBookService: GuestBookService,private router: Router) { }
    
    message = '';
    signup(usercredentials){
        if(!(usercredentials.userName === undefined || usercredentials.password === undefined
            || usercredentials.confirmPassword === undefined)){
            if(usercredentials.password!=usercredentials.confirmPassword){
                this.message = 'Password and confirm password should be same';
            }else{
                this.guestBookService.signupUser(this.usercredentials)
                .subscribe(data => this.message);
                let navigationExtras: NavigationExtras = {
                    queryParams: {
                        "username": this.usercredentials.userName
                    }
                };
                this.router.navigate(['guest'],navigationExtras);
            }
        }else{
            this.message='Please enter all the details';
        }
    }
}
