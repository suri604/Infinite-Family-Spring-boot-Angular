import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { NestedTreeControl } from '@angular/cdk/tree';
import { PersonService } from 'src/app/Services/person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
 
  nestedTreeControl: NestedTreeControl<Person>;
  
  dataChange: BehaviorSubject<Person[]> = new BehaviorSubject<Person[]>([]);
  data:any;
  
  private _getChildren = (node: Person) => { return of(node.children); };
   
  hasNestedChild = (_: number, nodeData: Person) => {if(nodeData.children){return true} else return false };

  constructor(private personService : PersonService, public nestedDataSource: MatTreeNestedDataSource<Person>) { }

  ngOnInit(): void {
    this.onSearch();
  }
  
 onSearch(){
  this.nestedTreeControl = new NestedTreeControl<Person>(this._getChildren);
  this.personService.getAllPersons().subscribe(res =>{
   this.data=res;
   this.dataChange.next(this.data);
   this.dataChange.subscribe(res => this.nestedDataSource.data = res); 
 });
 }
}
export class Person{
  id: number;
  name: string;
  age: number;
  parentId: number;
  children: Person[];
}