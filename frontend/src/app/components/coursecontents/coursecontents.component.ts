import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';
import { Location } from '@angular/common';
import { UploadFileService } from 'src/app/services/upload-file.service';
import { saveAs } from 'file-saver';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const AUTH_API = 'http://localhost:8080/api';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Component({
  selector: 'app-coursecontents',
  templateUrl: './coursecontents.component.html',
  styleUrls: ['./coursecontents.component.css']
})
export class CoursecontentsComponent implements OnInit {
  course: any = {};
  isTutor: boolean = false;
  courseId!: number;
  contents: any[] = [];

  constructor(private http: HttpClient,private route: ActivatedRoute, private userService: UserService, private tokenStorageService: TokenStorageService, private location:Location, private uploadService: UploadFileService) { }

  ngOnInit(): void {
    if(this.tokenStorageService.getUser().roles.indexOf("ROLE_TUTOR") !== -1) {
      this.isTutor = true;
    }
    this.route.params.subscribe((param: Params) => {
      this.courseId = param.id; // same as :username in route
    });
    
    

  this.userService.getContents(this.courseId).subscribe((data: any)=>{
    console.log(data);
    this.contents = data;
  });
  this.userService.getCourseDetails(this.courseId).subscribe((data: any)=>{
    console.log(data);
    this.course = data;
  });



  }
  deleteContent(contentId: number){
    return this.http.delete(AUTH_API+ "/course/content/" + contentId).subscribe();
  }

  downloadFile(fileurl: string, filename: string): void {
    this.uploadService
      .download(fileurl)
      .subscribe(blob => saveAs(blob, filename));
  }


}


