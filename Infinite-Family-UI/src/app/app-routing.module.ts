import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { HomeComponent } from './components/home/home.component';
import { PersonListComponent } from './components/person-list/person-list.component';
import { PersonMainComponent } from './components/person-main/person-main.component';


const routes: Routes = [
  {path: 'get/:parentId', component : ListComponent},
  {path: '', component : HomeComponent},
  {path: 'getlist', component : PersonListComponent},
  {path: 'postPersons', component : PersonMainComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
