import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RobotLayoutComponent } from './robot-layout.component';

describe('RobotLayoutComponent', () => {
  let component: RobotLayoutComponent;
  let fixture: ComponentFixture<RobotLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RobotLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RobotLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
