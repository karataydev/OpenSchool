import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentpanelComponent } from './studentpanel.component';

describe('StudentpanelComponent', () => {
  let component: StudentpanelComponent;
  let fixture: ComponentFixture<StudentpanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentpanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentpanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
