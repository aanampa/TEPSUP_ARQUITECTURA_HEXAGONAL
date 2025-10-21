import { Routes } from '@angular/router';
import { CarreraListComponent } from './components/carrera-list/carrera-list.component';
import { CarreraFormComponent } from './components/carrera-form/carrera-form.component';
import { FacultadListComponent } from './components/facultad-list/facultad-list.component';
import { FacultadFormComponent } from './components/facultad-form/facultad-form.component';

export const routes: Routes = [
  { path: '', redirectTo: '/facultades', pathMatch: 'full' },
  { path: 'facultades', component: FacultadListComponent },
  { path: 'facultades/nueva', component: FacultadFormComponent },
  { path: 'facultades/:id', component: FacultadFormComponent },
  { path: 'carreras', component: CarreraListComponent },
  { path: 'carreras/nueva', component: CarreraFormComponent },
  { path: 'carreras/:id', component: CarreraFormComponent },
  { path: '**', redirectTo: '/facultades' }
];
