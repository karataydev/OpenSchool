import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Params } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'jquery';

const AUTH_API = 'http://localhost:8080/api/course';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Component({
  selector: 'app-tutorcoursecontents',
  templateUrl: './tutorcoursecontents.component.html',
  styleUrls: ['./tutorcoursecontents.component.css']
})
export class TutorcoursecontentsComponent implements OnInit {
  course: any = {};
  form: any = {};
  courseId!: number;
  message: any;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    $(document).ready(function(){
      (<any>$('.modal')).modal();
    });
    this.route.params.subscribe((param: Params) => {
      this.courseId = param.id; // same as :username in route
    });
  }
  createContent(credentials:any): Observable<any>{
    if(this.message == null){
      
      return this.http.post(AUTH_API+ "/" + this.courseId, {
        title: credentials.title,
        description: credentials.description
      }, httpOptions);
    }
    return this.http.post(AUTH_API+ "/" + this.courseId, {
      title: credentials.title,
      description: credentials.description,
      fileUrl:this.message.url,
      fileName: this.message.name 
    }, httpOptions);

  }
  messagefrom(item: any){
    this.message = item;
    console.log(item);
    console.log(this.message);
  }


  onSubmit(){
    this.createContent(this.form).subscribe();
    window.parent.location.reload();
  }

}
