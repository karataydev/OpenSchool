import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorpanelComponent } from './tutorpanel.component';

describe('TutorpanelComponent', () => {
  let component: TutorpanelComponent;
  let fixture: ComponentFixture<TutorpanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorpanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorpanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
