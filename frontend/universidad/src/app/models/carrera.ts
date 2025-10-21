import { Facultad } from './facultad';

export interface Carrera {
  carreraId: number;
  facultadId: number;
  nombre: string;
  descripcion?: string;
  duracionSemestres: number;
  tituloOtorgado?: string;
  fechaRegistro: Date;
  activo: boolean;
  facultad?: Facultad;
}

export interface CreateCarrera {
  facultadId: number;
  nombre: string;
  descripcion?: string;
  duracionSemestres: number;
  tituloOtorgado?: string;
}

export interface UpdateCarrera {
  nombre?: string;
  descripcion?: string;
  duracionSemestres?: number;
  tituloOtorgado?: string;
  activo?: boolean;
}
