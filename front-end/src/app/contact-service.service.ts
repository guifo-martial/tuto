import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ContactServiceService {

  constructor(public http: Http ) { }

  getcontacts() {
    return this.http.get('/api/contacts')
              .map((resp) => resp.json());
  }

}
