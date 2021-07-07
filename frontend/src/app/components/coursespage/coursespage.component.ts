import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';
import { Course } from 'src/course';
import { HttpClient} from '@angular/common/http';

const AUTH_API = 'http://localhost:8080/api';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};




@Component({
  selector: 'app-coursespage',
  templateUrl: './coursespage.component.html',
  styleUrls: ['./coursespage.component.css']
})
export class CoursespageComponent implements OnInit {
  isLoggedIn = false;
  isTutor = false;
  courses: any[] = [];
  constructor(private http: HttpClient, private userService: UserService, private tokenStorageService: TokenStorageService) {
   }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    this.userService.getCourses().subscribe((data: any)=>{
      console.log(data);
      this.courses = data;
    })

    if(this.tokenStorageService.getUser().roles.indexOf("ROLE_TUTOR") !== -1) {
      this.isTutor = true;
    }
    
  }
  deleteCourse(courseId: number){
    return this.http.delete(AUTH_API+ "/course/" + courseId).subscribe();
  }
  unrollCourse(courseId: number){
    return this.http.delete(AUTH_API+ "/course/unroll/" + courseId).subscribe();
  }
  

}
