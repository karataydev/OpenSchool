import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursecontentsComponent } from './coursecontents.component';

describe('CoursecontentsComponent', () => {
  let component: CoursecontentsComponent;
  let fixture: ComponentFixture<CoursecontentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursecontentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursecontentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
