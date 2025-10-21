import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FacultadService } from '../../services/facultad.service';
import { Facultad, CreateFacultad, UpdateFacultad } from '../../models/facultad';

@Component({
  selector: 'app-facultad-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './facultad-form.component.html',
  styleUrls: ['./facultad-form.component.css']
})
export class FacultadFormComponent implements OnInit {
  facultadForm: FormGroup;
  isEdit = false;
  facultadId?: number;
  loading = false;
  submitting = false;
  error = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private facultadService: FacultadService
  ) {
    this.facultadForm = this.createForm();
  }

  ngOnInit(): void {
    this.facultadId = this.route.snapshot.params['id'];
    if (this.facultadId) {
      this.isEdit = true;
      this.loadFacultad(this.facultadId);
    }
  }

  createForm(): FormGroup {
    return this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      descripcion: ['', [Validators.maxLength(500)]],
      ubicacion: ['', [Validators.maxLength(100)]],
      decano: ['', [Validators.maxLength(100)]]
    });
  }

  loadFacultad(id: number): void {
    this.loading = true;
    this.facultadService.getFacultadById(id).subscribe({
      next: (facultad) => {
        this.facultadForm.patchValue({
          nombre: facultad.nombre,
          descripcion: facultad.descripcion || '',
          ubicacion: facultad.ubicacion || '',
          decano: facultad.decano || ''
        });
        this.loading = false;
      },
      error: (error) => {
        this.error = 'Error al cargar la facultad';
        this.loading = false;
        console.error('Error:', error);
      }
    });
  }

  onSubmit(): void {
    if (this.facultadForm.valid) {
      this.submitting = true;
      const formData = this.facultadForm.value;

      if (this.isEdit && this.facultadId) {
        const updateData: UpdateFacultad = {
          nombre: formData.nombre,
          descripcion: formData.descripcion,
          ubicacion: formData.ubicacion,
          decano: formData.decano
        };

        this.facultadService.updateFacultad(this.facultadId, updateData).subscribe({
          next: () => {
            this.router.navigate(['/facultades']);
          },
          error: (error) => {
            this.handleError('Error al actualizar la facultad', error);
          }
        });
      } else {
        const createData: CreateFacultad = {
          nombre: formData.nombre,
          descripcion: formData.descripcion,
          ubicacion: formData.ubicacion,
          decano: formData.decano
        };

        this.facultadService.createFacultad(createData).subscribe({
          next: () => {
            this.router.navigate(['/facultades']);
          },
          error: (error) => {
            this.handleError('Error al crear la facultad', error);
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
    Object.keys(this.facultadForm.controls).forEach(key => {
      const control = this.facultadForm.get(key);
      control?.markAsTouched();
    });
  }

  cancel(): void {
    this.router.navigate(['/facultades']);
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.facultadForm.get(fieldName);
    return !!(field && field.invalid && (field.dirty || field.touched));
  }

  getFieldError(fieldName: string): string {
    const field = this.facultadForm.get(fieldName);
    if (field?.errors) {
      if (field.errors['required']) return 'Este campo es requerido';
      if (field.errors['minlength']) return `Mínimo ${field.errors['minlength'].requiredLength} caracteres`;
      if (field.errors['maxlength']) return `Máximo ${field.errors['maxlength'].requiredLength} caracteres`;
    }
    return '';
  }
}
