package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.ComuBajaDTO;
import com.bicimoto.app.dto.DetComuBajaDTO;
import com.bicimoto.app.repository.ComuBajaRepository;
import com.bicimoto.app.response.*;
import com.bicimoto.app.service.ComBajaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ComBajaServiceImpl implements ComBajaService {

    @Autowired
    private ComuBajaRepository comuBajaRepository;

    @Override
    public DatosComBajaResponse getDatosComBaja(String ruc, String serie,String numero, String doc, String almacen,String id,String ndoc) {
        DatosComBajaResponse response = new DatosComBajaResponse();

        ComuBajaDTO comuBajaDTO = comuBajaRepository.BuscarComuBaja(ruc,serie,numero,doc,almacen,id,ndoc);

        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setRazon(comuBajaDTO.getRazon());
        empresaResponse.setNombreLegal(comuBajaDTO.getNombreLegal());
        empresaResponse.setUbigeo(comuBajaDTO.getUbigeo());
        empresaResponse.setDireccion(comuBajaDTO.getDireccion());
        empresaResponse.setNombreRegion(comuBajaDTO.getNombreRegion());
        empresaResponse.setNombreProvincia(comuBajaDTO.getNombreProvincia());
        empresaResponse.setNombreDistrito(comuBajaDTO.getNombreDistrito());
        empresaResponse.setUrbanizacion(comuBajaDTO.getUrbanizacion());

        ComBajaResponse comBajaResponse = new ComBajaResponse();
        comBajaResponse.setFecha(comuBajaDTO.getFecha());
        comBajaResponse.setNDocBaja(comuBajaDTO.getNDocBaja());
        comBajaResponse.setId(comuBajaDTO.getId());
        comBajaResponse.setArchXml(comuBajaDTO.getArchXml());
        comBajaResponse.setNomArchXml(comuBajaDTO.getNomArchXml());
        comBajaResponse.setTicket(comuBajaDTO.getTicket());

        List<DetComuBajaDTO> detComuBajaDTO = comuBajaRepository.BuscarDetComuBaja(ruc,comuBajaDTO.getNDocBaja(),id);
        List<DetalleComBajaResponse> detalleComBajaResponses = new ArrayList<>();

        detComuBajaDTO.stream().forEach(n->{
            DetalleComBajaResponse detallecomResponse = new DetalleComBajaResponse();
            detallecomResponse.setNumId(n.getNumId());
            detallecomResponse.setTipDoc(n.getTipDoc());
            detallecomResponse.setSerie(n.getSerie());
            detallecomResponse.setNumDoc(n.getNumDoc());
            detallecomResponse.setMotivoBaja(n.getMotivoBaja());
            detallecomResponse.setPrefijoSerie(n.getPrefijoSerie());
            detalleComBajaResponses.add(detallecomResponse);
        });

        response.setEmpresa(empresaResponse);
        response.setComuBaja(comBajaResponse);
        response.setDetallecomubaja(detalleComBajaResponses);

        return response;
    }
}
