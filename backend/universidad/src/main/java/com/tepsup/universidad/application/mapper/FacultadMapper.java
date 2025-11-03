package com.tepsup.universidad.application.mapper;
import org.springframework.stereotype.Component;

import com.tepsup.universidad.application.dto.command.RegisterCarreraCommand;
import com.tepsup.universidad.application.dto.command.RegisterFacultadCommand;
import com.tepsup.universidad.application.dto.response.FacultadResponse;
import com.tepsup.universidad.domain.model.Carrera;
import com.tepsup.universidad.domain.model.Facultad;

@Component
public class FacultadMapper {

    // Método para convertir de Entidad a Response
    public FacultadResponse toResponse(Facultad facultad) {
        if (facultad == null) {
            return null;
        }

        return new FacultadResponse(
            facultad.getFacultadId(),
            facultad.getNombre(),
            facultad.getDescripcion(),
            facultad.getUbicacion(),
            facultad.getDecano(),
            facultad.getFechaRegistro(),
            facultad.getActivo()
        );
    }

     public static RegisterFacultadCommand toCommand(Facultad facultad) {
        if (facultad == null) {
            return null;
        }

        return new RegisterFacultadCommand(
            facultad.getNombre(),
            facultad.getDescripcion(),
            facultad.getUbicacion(),
            facultad.getDecano()
        );
    }

}
