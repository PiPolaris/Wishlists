import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-feedback-messages',
  templateUrl: './feedback-messages.component.html',
  styleUrls: ['./feedback-messages.component.css']
})
export class FeedbackMessagesComponent implements OnInit {

  @Input() message = '';
  @Input() class = '';

  constructor() { }

  ngOnInit() {
  }

}
