import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {GuestBook} from '../guestbook';
import {GuestBookService} from '../guestbook.service';
import { UserInfoReq } from '../userInfoReq';

@Component({
    selector: 'app-guest',
    templateUrl: './guest.component.html'
})
export class GuestComponent {
   
    guestbook: GuestBook = new GuestBook();
    userInfo: UserInfoReq = new UserInfoReq();
    constructor(private guestBookService: GuestBookService,
        private route: ActivatedRoute) {
            this.route.queryParams.subscribe(params => {
                this.guestbook.userName = params["username"];
                      });
            
        }
        
        
    public files: any[];

contructor() { }
msg: string = null;
showMsg: boolean = false;
            
    register(userName,firstName,lastName,contactNo){
        if(!(userName === undefined || firstName === undefined
            || lastName === undefined || contactNo === lastName)){
                this.save();
        }else{
            this.msg = "Please enter all the details!";
        }
        
    }

    save() {
        this.userInfo.guestBook = this.guestbook;
        this.userInfo.userName = this.guestbook.userName;
        this.guestBookService.saveGuestData(this.userInfo)
          .subscribe(
            data => {this.msg = 'Guest successfully registered'
            ,this.showMsg= true},
            err => {console.log(err)    
          });
        this.guestbook = new GuestBook();
    }
}