package com.bicimoto.app.controller;

import com.bicimoto.app.response.DatosResumenResponse;
import com.bicimoto.app.service.ResumenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/resumen")
public class ResumenController {
    @Autowired
    private ResumenService resumenService;

    @PostMapping("/byData")
    public DatosResumenResponse getDataScheduler(@RequestParam String Ruc, @RequestParam String Serie, @RequestParam String Numero, @RequestParam String Doc, @RequestParam String Almacen,@RequestParam String Id,@RequestParam String NDoc){
        return resumenService.getDatosResumen(Ruc,Serie,Numero,Doc,Almacen,Id,NDoc);
    }
}
