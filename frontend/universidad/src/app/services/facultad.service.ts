import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Facultad, CreateFacultad, UpdateFacultad } from '../models/facultad';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FacultadService {
  private apiUrl = `${environment.apiUrl}/facultades`;

  constructor(private http: HttpClient) { }

  getFacultades(): Observable<Facultad[]> {
    return this.http.get<Facultad[]>(this.apiUrl);
  }

  getFacultadById(id: number): Observable<Facultad> {
    return this.http.get<Facultad>(`${this.apiUrl}/${id}`);
  }

  createFacultad(facultad: CreateFacultad): Observable<Facultad> {
    return this.http.post<Facultad>(this.apiUrl, facultad);
  }

  updateFacultad(id: number, facultad: UpdateFacultad): Observable<Facultad> {
    return this.http.put<Facultad>(`${this.apiUrl}/${id}`, facultad);
  }

  deleteFacultad(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
