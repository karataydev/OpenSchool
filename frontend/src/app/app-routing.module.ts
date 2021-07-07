import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursecontentsComponent } from './components/coursecontents/coursecontents.component';
import { CoursespageComponent } from './components/coursespage/coursespage.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: "", component: CoursespageComponent},
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'profile', component: ProfileComponent},
  { path: 'course/:id', component: CoursecontentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
