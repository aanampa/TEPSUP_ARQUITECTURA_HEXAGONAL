import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { Facultad } from '../../models/facultad';
import { FacultadService } from '../../services/facultad.service';

@Component({
  selector: 'app-facultad-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './facultad-list.component.html',
  styleUrls: ['./facultad-list.component.css']
})
export class FacultadListComponent implements OnInit {
  facultades: Facultad[] = [];
  loading = false;
  error = '';

  constructor(
    private facultadService: FacultadService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadFacultades();
  }

  loadFacultades(): void {
    this.loading = true;
    this.facultadService.getFacultades().subscribe({
      next: (data) => {
        this.facultades = data;
        this.loading = false;
      },
      error: (error) => {
        this.error = 'Error al cargar las facultades';
        this.loading = false;
        console.error('Error:', error);
      }
    });
  }

  deleteFacultad(id: number): void {
    if (confirm('¿Está seguro de que desea eliminar esta facultad?')) {
      this.facultadService.deleteFacultad(id).subscribe({
        next: () => {
          this.facultades = this.facultades.filter(f => f.facultadId !== id);
        },
        error: (error) => {
          alert('Error al eliminar la facultad');
          console.error('Error:', error);
        }
      });
    }
  }

  editFacultad(id: number): void {
    this.router.navigate(['/facultades', id]);
  }

  createFacultad(): void {
    this.router.navigate(['/facultades/nueva']);
  }

  getEstadoBadge(activo: boolean): string {
    return activo ? 'bg-success' : 'bg-secondary';
  }

  getEstadoText(activo: boolean): string {
    return activo ? 'Activo' : 'Inactivo';
  }
}
