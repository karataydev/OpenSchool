import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorcoursecontentsComponent } from './tutorcoursecontents.component';

describe('TutorcoursecontentsComponent', () => {
  let component: TutorcoursecontentsComponent;
  let fixture: ComponentFixture<TutorcoursecontentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorcoursecontentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorcoursecontentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
