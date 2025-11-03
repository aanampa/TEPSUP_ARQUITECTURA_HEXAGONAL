package com.tepsup.universidad.infrastructure.adapter.in.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tepsup.universidad.application.dto.command.RegisterFacultadCommand;
import com.tepsup.universidad.application.dto.command.UpdateFacultadCommand;
import com.tepsup.universidad.application.dto.response.FacultadResponse;
import com.tepsup.universidad.application.port.in.FacultadUseCase;
import com.tepsup.universidad.domain.exception.FacultadNotFoundException;
import com.tepsup.universidad.domain.model.Facultad;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/facultades")
@Tag(name = "Facultades", description = "Gestión de facultades")
@CrossOrigin(origins = "*")
public class FacultadController {

    private final FacultadUseCase facultadUseCase;

    public FacultadController(FacultadUseCase registerFacultadUseCase) {
        this.facultadUseCase = registerFacultadUseCase;
    }

    @PostMapping
    @Operation(summary = "Registrar nueva facultad", description = "Registra una nueva facultad en el sistema")
    public ResponseEntity<FacultadResponse> registerFacultad(@Valid @RequestBody RegisterFacultadCommand command) {

        FacultadResponse response = facultadUseCase.register(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Actualizar facultad", description = "Actualiza los datos de una facultad existente")
    public ResponseEntity<FacultadResponse> actualizarFacultad(
            @PathVariable Integer id, 
            @Valid @RequestBody UpdateFacultadCommand command) {
        
        FacultadResponse response = facultadUseCase.actualizar(id, command);
               
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        facultadUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener facultad por su Id", description = "Obtiene facultad por su Id")
    public ResponseEntity<FacultadResponse> getFacultad(@PathVariable Integer id) {
  
        Facultad facultad = facultadUseCase.obtenerPorId(id)
                .orElseThrow(() -> new FacultadNotFoundException(id));
                
        return ResponseEntity.ok(mapToResponse(facultad));
    }

    @GetMapping
    @Operation(summary = "Lista todas las facultades", description = "Lista todas las facultades")
    public ResponseEntity<List<FacultadResponse>> getFacultades() {
  
        List<Facultad> facultades = facultadUseCase.listarTodos();

        return ResponseEntity.ok(facultades.stream()
                    .map(this::mapToResponse)
                    .collect(Collectors.toList()));
    
    }

    private FacultadResponse mapToResponse(Facultad facultad) {
        FacultadResponse response = new FacultadResponse();
        response.setFacultadId(facultad.getFacultadId());
        response.setNombre(facultad.getNombre());
        response.setDescripcion(facultad.getDescripcion());
        response.setUbicacion(facultad.getUbicacion());
        response.setDecano(facultad.getDecano());
        response.setFechaRegistro(facultad.getFechaRegistro());
        response.setActivo(facultad.getActivo());
        return response;
    }

    @ExceptionHandler(FacultadNotFoundException.class)
    public ResponseEntity<String> handleFacultadNotFound(FacultadNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
