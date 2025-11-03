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

import com.tepsup.universidad.application.dto.command.RegisterCarreraCommand;
import com.tepsup.universidad.application.dto.command.UpdateCarreraCommand;
import com.tepsup.universidad.application.dto.response.CarreraResponse;
import com.tepsup.universidad.application.port.in.CarreraUseCase;
import com.tepsup.universidad.domain.exception.CarreraNotFoundException;
import com.tepsup.universidad.domain.model.Carrera;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/carreras")
@Tag(name = "Carreras", description = "Gestión de carreras")
@CrossOrigin(origins = "*")
public class CarreraController {

    private final CarreraUseCase carreraUseCase;

    public CarreraController(CarreraUseCase carreraUseCase) {
        this.carreraUseCase = carreraUseCase;
    }

    @PostMapping
    @Operation(summary = "Registrar nueva facultad", description = "Registra una nueva facultad en el sistema")
    public ResponseEntity<CarreraResponse> registrarCarrera(@Valid @RequestBody RegisterCarreraCommand command) {

        System.out.println("- CarreraController > registrarCarrera > commanad: " + command.toString());

        CarreraResponse response = carreraUseCase.grabar(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar carrera", description = "Actualiza los datos de una carrera existente")
    public ResponseEntity<CarreraResponse> actualizarCarrera(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCarreraCommand command) {

        System.out.println("- CarreraController > actualizarCarrera > command: " + command.toString());                

        CarreraResponse response = carreraUseCase.actualizar(id, command);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        carreraUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una carrera por su Id", description = "Obtiene una carrera por su Id")
    public ResponseEntity<CarreraResponse> getCarrera(@PathVariable Integer id) {

        Carrera carrera = carreraUseCase.obtenerPorId(id)
                .orElseThrow(() -> new CarreraNotFoundException(id));

        return ResponseEntity.ok(mapToResponse(carrera));
    }

    @GetMapping
    @Operation(summary = "Lista todas las carreras", description = "Lista todas las carreras registradas en el sistema")
    public ResponseEntity<List<CarreraResponse>> getCarreraes() {

        List<Carrera> carreras = carreraUseCase.listarTodos();

        return ResponseEntity.ok(carreras.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList()));

    }

    private CarreraResponse mapToResponse(Carrera carrera) {
        CarreraResponse response = new CarreraResponse();
        response.setCarreraId(carrera.getCarreraId());
        response.setFacultadId(carrera.getFacultadId());
        response.setNombre(carrera.getNombre());
        response.setDescripcion(carrera.getDescripcion());
        response.setDuracionSemestres(carrera.getDuracionSemestres());
        response.setTituloOtorgado(carrera.getTituloOtorgado());
        response.setFechaRegistro(carrera.getFechaRegistro());
        response.setActivo(carrera.getActivo());
        return response;
    }

    @ExceptionHandler(CarreraNotFoundException.class)
    public ResponseEntity<String> handleFacultadNotFound(CarreraNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
