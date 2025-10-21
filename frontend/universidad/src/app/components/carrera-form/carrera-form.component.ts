import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CarreraService } from '../../services/carrera.service';
import { FacultadService } from '../../services/facultad.service';
import { Facultad } from '../../models/facultad';
import { Carrera, CreateCarrera, UpdateCarrera } from '../../models/carrera';

@Component({
  selector: 'app-carrera-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './carrera-form.component.html',
  styleUrls: ['./carrera-form.component.css']
})
export class CarreraFormComponent implements OnInit {
  carreraForm: FormGroup;
  facultades: Facultad[] = [];
  isEdit = false;
  carreraId?: number;
  loading = false;
  submitting = false;
  error = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private carreraService: CarreraService,
    private facultadService: FacultadService
  ) {
    this.carreraForm = this.createForm();
  }

  ngOnInit(): void {
    this.loadFacultades();

    this.carreraId = this.route.snapshot.params['id'];
    if (this.carreraId) {
      this.isEdit = true;
      this.loadCarrera(this.carreraId);
    }
  }

  createForm(): FormGroup {
    return this.fb.group({
      facultadId: ['', [Validators.required, Validators.min(1)]],
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      descripcion: ['', [Validators.maxLength(500)]],
      duracionSemestres: ['', [Validators.required, Validators.min(1), Validators.max(20)]],
      tituloOtorgado: ['', [Validators.maxLength(100)]]
    });
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

  loadCarrera(id: number): void {
    this.loading = true;
    this.carreraService.getCarreraById(id).subscribe({
      next: (carrera) => {
        this.carreraForm.patchValue({
          facultadId: carrera.facultadId,
          nombre: carrera.nombre,
          descripcion: carrera.descripcion || '',
          duracionSemestres: carrera.duracionSemestres,
          tituloOtorgado: carrera.tituloOtorgado || ''
        });
        this.loading = false;
      },
      error: (error) => {
        this.error = 'Error al cargar la carrera';
        this.loading = false;
        console.error('Error:', error);
      }
    });
  }

  onSubmit(): void {
    if (this.carreraForm.valid) {
      this.submitting = true;
      const formData = this.carreraForm.value;

      if (this.isEdit && this.carreraId) {
        const updateData: UpdateCarrera = {
          nombre: formData.nombre,
          descripcion: formData.descripcion,
          duracionSemestres: formData.duracionSemestres,
          tituloOtorgado: formData.tituloOtorgado
        };

        this.carreraService.updateCarrera(this.carreraId, updateData).subscribe({
          next: () => {
            this.router.navigate(['/carreras']);
          },
          error: (error) => {
            this.handleError('Error al actualizar la carrera', error);
          }
        });
      } else {
        const createData: CreateCarrera = {
          facultadId: formData.facultadId,
          nombre: formData.nombre,
          descripcion: formData.descripcion,
          duracionSemestres: formData.duracionSemestres,
          tituloOtorgado: formData.tituloOtorgado
        };

        this.carreraService.createCarrera(createData).subscribe({
          next: () => {
            this.router.navigate(['/carreras']);
          },
          error: (error) => {
            this.handleError('Error al crear la carrera', error);
          }
        });
      }
    } else {
      this.markFormGroupTouched();
    }
  }

  private handleError(message: string, error: any): void {
    this.error = message;
    this.submitting = false;
    console.error('Error:', error);
  }

  private markFormGroupTouched(): void {
    Object.keys(this.carreraForm.controls).forEach(key => {
      const control = this.carreraForm.get(key);
      control?.markAsTouched();
    });
  }

  cancel(): void {
    this.router.navigate(['/carreras']);
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.carreraForm.get(fieldName);
    return !!(field && field.invalid && (field.dirty || field.touched));
  }

  getFieldError(fieldName: string): string {
    const field = this.carreraForm.get(fieldName);
    if (field?.errors) {
      if (field.errors['required']) return 'Este campo es requerido';
      if (field.errors['minlength']) return `Mínimo ${field.errors['minlength'].requiredLength} caracteres`;
      if (field.errors['maxlength']) return `Máximo ${field.errors['maxlength'].requiredLength} caracteres`;
      if (field.errors['min']) return `El valor mínimo es ${field.errors['min'].min}`;
      if (field.errors['max']) return `El valor máximo es ${field.errors['max'].max}`;
    }
    return '';
  }
}
