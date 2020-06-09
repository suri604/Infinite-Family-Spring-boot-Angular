import { Component, OnInit } from '@angular/core';
import {Form} from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  form: Form;
 
  constructor() { }

  ngOnInit(): void {
  }
  

}
