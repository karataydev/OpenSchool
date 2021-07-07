import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import 'jquery';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';

const AUTH_API = 'http://localhost:8080/api/course';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Component({
  selector: 'app-tutorpanel',
  templateUrl: './tutorpanel.component.html',
  styleUrls: ['./tutorpanel.component.css']
})
export class TutorpanelComponent implements OnInit {
  form: any = {};
  currentUser: any;
  isTutor: boolean = false;;
  constructor(private http: HttpClient, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    $(document).ready(function(){
      (<any>$('.modal')).modal();
    });
    
    
  }
  createCourse(credentials:any): Observable<any> {
    return this.http.post(AUTH_API, {
      code: credentials.code,
      name: credentials.name,
      description: credentials.description,
      tutorUsername: this.currentUser.username
    }, httpOptions);
  }
  onSubmit(){
    this.createCourse(this.form).subscribe();
    window.parent.location.reload();
  }



}
