import { ContactServiceService } from '../contact-service.service';
import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Routes } from '@angular/router';
import 'rxjs/add/operator/map';


@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css']
})
export class ContactsComponent implements OnInit {

   listContact: {} ;

  constructor(public http: Http, public contactService: ContactServiceService) { }

  ngOnInit() {
    this.contactService.getcontacts()
              .subscribe(data => {
                this.listContact = data;
              }, err =>  {
                console.log( ' error' );
              })
  }

}
