import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import {GuestBook} from './guestbook';
import { Observable } from 'rxjs';
import { UserInfoReq } from './userInfoReq';

@Injectable()
export class GuestBookService {

    private baseUrl = 'http://localhost:8080/api/guests';
 
    constructor(private http: HttpClient) { }

    uploadImage(formData){
      return this.http.post(`${this.baseUrl}` + `/upload`, formData);
    }
   
    saveGuestData(userInfo){
      return this.http.post(`${this.baseUrl}` + `/register`, userInfo);
    }

  getGuestEntries(): Observable<GuestBook[]>{
    return this.http.get<GuestBook[]>(`${this.baseUrl}` + `/getList`);
  } 

  approveGuestEntry(guestdetail){
    return this.http.post(`${this.baseUrl}` + `/approve`, guestdetail);
  }

  rejectGuestEntry(guestdetail){
    return this.http.post(`${this.baseUrl}` + `/reject`, guestdetail);
  }

  signupUser(usercredentials){
    return this.http.post(`${this.baseUrl}` + `/signupUser`, usercredentials);
  }

  validateUser(usercredentials): Observable<UserInfoReq>{
    return this.http.get<UserInfoReq>(`${this.baseUrl}` + `/validateUser`, {params:usercredentials});
  }

}