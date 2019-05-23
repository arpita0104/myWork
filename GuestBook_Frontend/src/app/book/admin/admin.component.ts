import { Component,OnInit} from '@angular/core'
import {GuestBook} from '../guestbook';
import {GuestBookService} from '../guestbook.service';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-admin',
    templateUrl: './admin.component.html'
})
export class AdminComponent implements OnInit {
message;
    // guestdetail: GuestBook = new GuestBook();
    constructor(private guestBookService: GuestBookService) { }
    public guestlist = [];
    ngOnInit() {
        this.reloadData();
    }

    reloadData() {
        this.guestBookService.getGuestEntries()
        .subscribe(data => this.guestlist = data);
    }

    approve(guestdetail){
        this.guestBookService.approveGuestEntry(guestdetail)
        .subscribe(data => this.message = 'Guest entry approved', error => console.log(error));
        this.reloadData();
    }

    reject(guestdetail){
        this.guestBookService.rejectGuestEntry(guestdetail)
        .subscribe(data => this.message = 'Guest entry rejected', error => console.log(error));
        this.reloadData();
}
    }

