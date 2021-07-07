import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursespageComponent } from './coursespage.component';

describe('CoursespageComponent', () => {
  let component: CoursespageComponent;
  let fixture: ComponentFixture<CoursespageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursespageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursespageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
