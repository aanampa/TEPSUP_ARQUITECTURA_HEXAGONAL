package com.tepsup.universidad.application.mapper;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.Objects;
//import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tepsup.universidad.application.dto.command.RegisterCarreraCommand;
import com.tepsup.universidad.application.dto.response.CarreraResponse;
import com.tepsup.universidad.domain.model.Carrera;

@Component
public class CarreraMapper {

    // Método para convertir de Entidad a Response
    public CarreraResponse toResponse(Carrera carrera) {
        if (carrera == null) {
            return null;
        }

        return new CarreraResponse(
            carrera.getCarreraId(),
            carrera.getFacultadId(),
            carrera.getNombre(),
            carrera.getDescripcion(),
            carrera.getDuracionSemestres(),
            carrera.getTituloOtorgado(),
            carrera.getFechaRegistro(),
            carrera.getActivo()
        );
    }

    // Método para convertir de Command a Entidad (para creación)
    public static Carrera fromCommand(RegisterCarreraCommand command) {
        if (command == null) {
            return null;
        }

        Carrera carrera = new Carrera();
        carrera.setFacultadId(command.getFacultadId());
        carrera.setNombre(command.getNombre());
        carrera.setDescripcion(command.getDescripcion());
        carrera.setDuracionSemestres(command.getDuracionSemestres());
        carrera.setTituloOtorgado(command.getTituloOtorgado());
        carrera.setFechaRegistro(LocalDateTime.now());
        carrera.setActivo(true);
        
        return carrera;
    }

    // Método para actualizar entidad desde Command
    public static void updateFromCommand(Carrera carrera, RegisterCarreraCommand command) {
        if (carrera == null || command == null) {
            return;
        }

        carrera.setFacultadId(command.getFacultadId());
        carrera.setNombre(command.getNombre());
        carrera.setDescripcion(command.getDescripcion());
        carrera.setDuracionSemestres(command.getDuracionSemestres());
        carrera.setTituloOtorgado(command.getTituloOtorgado());
        // fechaRegistro y activo no se actualizan aquí
    }

    // Método para convertir lista de Entidades a lista de Responses
    /*
    public static List<CarreraResponse> toResponseList(List<Carrera> carreras) {
        if (carreras == null) {
            return List.of();
        }

        return carreras.stream()
                .map(CarreraMapper::toResponse)
                .collect(Collectors.toList());
    }
    */
    // Método para crear Response con datos básicos (sin campos sensibles)
    public static CarreraResponse toBasicResponse(Carrera carrera) {
        if (carrera == null) {
            return null;
        }

        CarreraResponse response = new CarreraResponse();
        response.setCarreraId(carrera.getCarreraId());
        response.setFacultadId(carrera.getFacultadId());
        response.setNombre(carrera.getNombre());
        response.setDuracionSemestres(carrera.getDuracionSemestres());
        response.setTituloOtorgado(carrera.getTituloOtorgado());
        response.setActivo(carrera.getActivo());
        
        return response;
    }

    // Método para crear Response desde entidad existente (usando constructor de CarreraResponse)
    /* 
    public static CarreraResponse fromEntity(Carrera carrera) {
        return new CarreraResponse(carrera);
    }
    */

    // Método para mapear parcialmente una entidad (útil para updates parciales)
    public static void partialUpdate(Carrera target, Carrera source) {
        if (target == null || source == null) {
            return;
        }

        if (source.getFacultadId() != null) {
            target.setFacultadId(source.getFacultadId());
        }
        if (source.getNombre() != null) {
            target.setNombre(source.getNombre());
        }
        if (source.getDescripcion() != null) {
            target.setDescripcion(source.getDescripcion());
        }
        if (source.getDuracionSemestres() != null) {
            target.setDuracionSemestres(source.getDuracionSemestres());
        }
        if (source.getTituloOtorgado() != null) {
            target.setTituloOtorgado(source.getTituloOtorgado());
        }
        if (source.getActivo() != null) {
            target.setActivo(source.getActivo());
        }
    }

    // Método para crear un Command desde una entidad (útil para edición)
    public static RegisterCarreraCommand toCommand(Carrera carrera) {
        if (carrera == null) {
            return null;
        }

        return new RegisterCarreraCommand(
            carrera.getFacultadId(),
            carrera.getNombre(),
            carrera.getDescripcion(),
            carrera.getDuracionSemestres(),
            carrera.getTituloOtorgado()
        );
    }

    // Método para verificar si dos carreras son equivalentes (excluyendo ID y fechas)
    public static boolean areEquivalent(Carrera carrera1, Carrera carrera2) {
        if (carrera1 == null && carrera2 == null) return true;
        if (carrera1 == null || carrera2 == null) return false;

        return Objects.equals(carrera1.getFacultadId(), carrera2.getFacultadId()) &&
               Objects.equals(carrera1.getNombre(), carrera2.getNombre()) &&
               Objects.equals(carrera1.getDescripcion(), carrera2.getDescripcion()) &&
               Objects.equals(carrera1.getDuracionSemestres(), carrera2.getDuracionSemestres()) &&
               Objects.equals(carrera1.getTituloOtorgado(), carrera2.getTituloOtorgado()) &&
               Objects.equals(carrera1.getActivo(), carrera2.getActivo());
    }
}