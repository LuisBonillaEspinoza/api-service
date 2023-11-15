package com.bicimoto.app.controller;

import com.bicimoto.app.response.DatosComBajaResponse;
import com.bicimoto.app.response.DatosResponse;
import com.bicimoto.app.service.ComBajaService;
import com.bicimoto.app.service.DatosScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/comuBaja")
public class ComuBajaController {
    @Autowired
    private ComBajaService comBajaService;

    @PostMapping("/byData")
    public DatosComBajaResponse getDataScheduler(@RequestParam String Ruc, @RequestParam String Serie,@RequestParam String Numero, @RequestParam String Doc, @RequestParam String Almacen,@RequestParam String Id,@RequestParam String NDoc){
        return comBajaService.getDatosComBaja(Ruc,Serie,Numero,Doc,Almacen,Id,NDoc);
    }
}
