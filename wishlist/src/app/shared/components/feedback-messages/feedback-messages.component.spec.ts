import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackMessagesComponent } from './feedback-messages.component';

describe('FeedbackMessagesComponent', () => {
  let component: FeedbackMessagesComponent;
  let fixture: ComponentFixture<FeedbackMessagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeedbackMessagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackMessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
