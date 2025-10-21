export interface Facultad {
  facultadId: number;
  nombre: string;
  descripcion?: string;
  ubicacion?: string;
  decano?: string;
  fechaRegistro: Date;
  activo: boolean;
}

export interface CreateFacultad {
  nombre: string;
  descripcion?: string;
  ubicacion?: string;
  decano?: string;
}

export interface UpdateFacultad {
  nombre?: string;
  descripcion?: string;
  ubicacion?: string;
  decano?: string;
  activo?: boolean;
}
