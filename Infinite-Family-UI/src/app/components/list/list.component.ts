import { Component, OnInit } from '@angular/core';

import { NestedTreeControl } from '@angular/cdk/tree';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { BehaviorSubject, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { PersonService } from 'src/app/Services/person.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  nestedTreeControl: NestedTreeControl<Person>;
  
  dataChange: BehaviorSubject<Person[]> = new BehaviorSubject<Person[]>([]);
  data:any;
  parentId:number;
  
  private _getChildren = (node: Person) => { return of(node.children); };
   
  hasNestedChild = (_: number, nodeData: Person) => {if(nodeData.children){return true} else return false };
  

  constructor(private personService : PersonService, public nestedDataSource: MatTreeNestedDataSource<Person>,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.onSubmit(this.activatedRoute.snapshot.params.id);
  }
  onSubmit(id)
  {
    this.nestedTreeControl = new NestedTreeControl<Person>(this._getChildren);
    this.personService.getAllPersonById(id).subscribe(res =>{
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
