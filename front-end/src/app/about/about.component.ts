import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
 contact = {nom:"nomTest",email:"mail@mail.com",tel :"0605041253"};
  constructor() { }

  ngOnInit() {
  }

}
