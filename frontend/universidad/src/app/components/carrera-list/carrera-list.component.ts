import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { Carrera } from '../../models/carrera';
import { CarreraService } from '../../services/carrera.service';

@Component({
  selector: 'app-carrera-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './carrera-list.component.html',
  styleUrls: ['./carrera-list.component.css']
})
export class CarreraListComponent implements OnInit {
  carreras: Carrera[] = [];
  loading = false;
  error = '';

  constructor(
    private carreraService: CarreraService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadCarreras();
  }

  loadCarreras(): void {
    this.loading = true;
    this.carreraService.getCarreras().subscribe({
      next: (data) => {
        this.carreras = data;
        this.loading = false;
      },
      error: (error) => {
        this.error = 'Error al cargar las carreras';
        this.loading = false;
        console.error('Error:', error);
      }
    });
  }

  deleteCarrera(id: number): void {
    if (confirm('¿Está seguro de que desea eliminar esta carrera?')) {
      this.carreraService.deleteCarrera(id).subscribe({
        next: () => {
          this.carreras = this.carreras.filter(c => c.carreraId !== id);
        },
        error: (error) => {
          alert('Error al eliminar la carrera');
          console.error('Error:', error);
        }
      });
    }
  }

  editCarrera(id: number): void {
    this.router.navigate(['/carreras', id]);
  }

  createCarrera(): void {
    this.router.navigate(['/carreras/nueva']);
  }

  getEstadoBadge(activo: boolean): string {
    return activo ? 'bg-success' : 'bg-secondary';
  }

  getEstadoText(activo: boolean): string {
    return activo ? 'Activo' : 'Inactivo';
  }
}
