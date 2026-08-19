import { Component, signal } from '@angular/core';
import { PollComponent } from './components/poll/poll.component';

@Component({
  selector: 'app-root',
  imports: [PollComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend-poll-app');
}
