import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private url: string = "http://localhost:8085/get/Persons";
  private url1: string = "http://localhost:8085/post/Persons";
  private url2: string = "http://localhost:8085/get/Personby/";
  constructor(private http : HttpClient) { }

  getAllPersons() : Observable<any>{
    return this.http.get<any>(this.url);
  }
  postPersonsData(name: String, age : Number , parentId : Number) {
    console.log("Person DataData inputed");
    return this.http.post(this.url1,    
      {
        "name" : name,
        "age":age,
        "parentId":parentId
      })
  }
  getAllPersonById(id) : Observable<any>{
    return this.http.get<any>(this.url2 + id);
  }

}
