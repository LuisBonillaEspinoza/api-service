package com.bicimoto.app.controller;

import com.bicimoto.app.response.DatosResponse;
import com.bicimoto.app.service.DatosScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ventas")

public class DatosScheduleController {
    @Autowired
    private DatosScheduleService datosScheduleService;

    @PostMapping("/byData")
    public DatosResponse getDataScheduler(@RequestParam String TipoDocumento, @RequestParam String Numero, @RequestParam String Serie, @RequestParam String Ruc, @RequestParam String Almacen){
        return datosScheduleService.getDatosScheduler(TipoDocumento,Numero,Serie,Ruc,Almacen);
    }
}
