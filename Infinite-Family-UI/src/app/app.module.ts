import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HttpClientModule } from '@angular/common/http';
import { PersonMainComponent } from './components/person-main/person-main.component';
import { PersonListComponent } from './components/person-list/person-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTreeModule, MatTreeNestedDataSource} from '@angular/material/tree';
import { PersonService } from './Services/person.service';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListComponent,
    PersonMainComponent,
    PersonListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    MatTreeModule, MatIconModule, MatButtonModule,MatToolbarModule,
    BrowserAnimationsModule
  ],
  providers: [MatTreeNestedDataSource, PersonService],
  bootstrap: [AppComponent],
  exports: [ MatTreeModule, MatIconModule, MatButtonModule,MatToolbarModule, BrowserAnimationsModule]
})
export class AppModule { }
