import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoursespageComponent } from './components/coursespage/coursespage.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CoursecontentsComponent } from './components/coursecontents/coursecontents.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UploadfilesComponent } from './components/uploadfiles/uploadfiles.component';
import { TutorpanelComponent } from './components/tutorpanel/tutorpanel.component';
import { TutorcoursecontentsComponent } from './components/coursecontents/tutorcoursecontents/tutorcoursecontents.component';
import { StudentpanelComponent } from './components/studentpanel/studentpanel.component';


@NgModule({
  declarations: [
    AppComponent,
    CoursespageComponent,
    RegisterComponent,
    LoginComponent,
    ProfileComponent,
    CoursecontentsComponent,
    NavbarComponent,
    UploadfilesComponent,
    TutorpanelComponent,
    TutorcoursecontentsComponent,
    StudentpanelComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
