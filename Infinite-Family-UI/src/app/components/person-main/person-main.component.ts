import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListComponent } from '../list/list.component';
import { PersonService } from 'src/app/Services/person.service';
import { PersonListComponent } from '../person-list/person-list.component';

@Component({
  selector: 'app-person-main',
  templateUrl: './person-main.component.html',
  styleUrls: ['./person-main.component.css'],
  providers: [ListComponent, PersonListComponent]
})
export class PersonMainComponent implements OnInit {

  constructor(private personService : PersonService, private route:Router, private list: ListComponent, private personList: PersonListComponent) { }
  person: Person;
  parentId:any;
  ngOnInit(): void {
  }
  onSubmit(name, age, parentId) {
    this.personService.postPersonsData(name, age, parentId).subscribe(data => {
      console.log(data);
    })
    
  
  alert('SUCCESS!! :-)\n\n' + JSON.stringify("Successfully saved the data", null, 4));
}
onSearch(){
  this.route.navigate(["/get",this.parentId]);
   this.list.onSubmit(this.parentId);
    }
 onGettingAllData(){
  this.route.navigate(["/getlist"]);
    this.personList.onSearch();
        }
}
export class Person{
  id: number;
  name: string;
  age: number;
  parentId: number;
  children: Person[];
}