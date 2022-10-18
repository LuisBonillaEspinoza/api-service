package com.bicimoto.app.controller;

import com.bicimoto.app.repository.IngresoRepository;
import com.bicimoto.app.request.IngresoRequest;
import com.bicimoto.app.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
    private IngresoService guiaRemisionService;

    @Autowired
    private IngresoRepository ingresoRepository;

    @PostMapping("/add")
    public ResponseEntity<?> saveGuia(@RequestBody IngresoRequest request) throws Exception{
        IngresoRequest remisionRequest = null;
        List<IngresoRequest> list = new ArrayList<>();
        try{
            remisionRequest = guiaRemisionService.saveGuiaRemision(request , null);

        } catch (Exception e){
            return buildResponseError("Error al registrar los datos", e);
        }

        if (remisionRequest == null) {
            throw new Exception("No se puede realizar el registro de la información");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("Mensaje", "Registro creado satisfactoriamente");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGuia(@RequestBody IngresoRequest request, @PathVariable String id) throws Exception{
        IngresoRequest remisionRequest = null;
        List<IngresoRequest> list = new ArrayList<>();
        request.setId(id);
        try{
            remisionRequest = guiaRemisionService.saveGuiaRemision(request, id);

        } catch (Exception e){
            return buildResponseError("Error al modificar los datos", e);
        }

        if (remisionRequest == null) {
            throw new Exception("No se puede realizar la modificación de la información");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("Mensaje", "Registro actualizado satisfactoriamente");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> buildResponseError(String error, Exception exception) {
        Map<String, Object> response = new HashMap<>();

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if (exception != null) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            if (exception.getMessage() != null) {
                error = exception.getMessage();
            }
        }
        response.put("Mensaje", error);
        return new ResponseEntity<Map<String, Object>>(response, httpStatus);
    }
}
