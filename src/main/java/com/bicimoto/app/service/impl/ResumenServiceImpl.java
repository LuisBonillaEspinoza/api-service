package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.ComuBajaDTO;
import com.bicimoto.app.dto.DetResumenDTO;
import com.bicimoto.app.dto.ResumenDTO;
import com.bicimoto.app.repository.ResumenRepository;
import com.bicimoto.app.response.DatosResumenResponse;
import com.bicimoto.app.response.DetalleResumenResponse;
import com.bicimoto.app.response.EmpresaResponse;
import com.bicimoto.app.response.ResumenResponse;
import com.bicimoto.app.service.ResumenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ResumenServiceImpl implements ResumenService {
    @Autowired
    private ResumenRepository resumenRepository;

    @Override
    public DatosResumenResponse getDatosResumen(String ruc, String serie, String numero, String doc, String almacen,String id,String ndoc) {
        DatosResumenResponse datosResumenResponse = new DatosResumenResponse();

        ResumenDTO comuBajaDTO = resumenRepository.BuscarResumen(ruc,serie,numero,doc,almacen,id,ndoc);

        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setRazon(comuBajaDTO.getRazon());
        empresaResponse.setNombreLegal(comuBajaDTO.getNombreLegal());
        empresaResponse.setUbigeo(comuBajaDTO.getUbigeo());
        empresaResponse.setDireccion(comuBajaDTO.getDireccion());
        empresaResponse.setUrbanizacion(comuBajaDTO.getUrbanizacion());
        empresaResponse.setTelefono(comuBajaDTO.getTelefono());
        empresaResponse.setCelular(comuBajaDTO.getCelular());
        empresaResponse.setRepresentante(comuBajaDTO.getRepresentante());
        empresaResponse.setEmail(comuBajaDTO.getEmail());
        empresaResponse.setTelefono2(comuBajaDTO.getTelefono2());
        empresaResponse.setNombreRegion(comuBajaDTO.getNombreRegion());
        empresaResponse.setNombreDistrito(comuBajaDTO.getNombreDistrito());
        empresaResponse.setNombreProvincia(comuBajaDTO.getNombreProvincia());

        ResumenResponse resumenResponse = new ResumenResponse();
        resumenResponse.setId(comuBajaDTO.getId());
        resumenResponse.setFecha(comuBajaDTO.getFecha());
        resumenResponse.setNDocResumen(comuBajaDTO.getNDocResumen());
        resumenResponse.setArchXml(comuBajaDTO.getArchXml());
        resumenResponse.setNomArchXml(comuBajaDTO.getNomArchXml());
        resumenResponse.setTicket(comuBajaDTO.getTicket());

        List<DetalleResumenResponse> detalleResumenResponseList = new ArrayList<>();
        List<DetResumenDTO> resumenDTO = resumenRepository.BuscarDetResumen(ruc, comuBajaDTO.getNDocResumen(),id);
        resumenDTO.stream().forEach(n->{
            DetalleResumenResponse detalleResumenResponse = new DetalleResumenResponse();
            detalleResumenResponse.setNumId(n.getNumId());
            detalleResumenResponse.setSerie(n.getSerie());
            detalleResumenResponse.setInicio(n.getInicio());
            detalleResumenResponse.setCliente(n.getCliente());
            detalleResumenResponse.setTotal(n.getTotal());
            detalleResumenResponse.setTBruto(n.getTBruto());
            detalleResumenResponse.setTInafecta(n.getTInafecta());
            detalleResumenResponse.setTGratuita(n.getTGratuita());
            detalleResumenResponse.setDcto(n.getDcto());
            detalleResumenResponse.setPrefijoSerie(n.getPrefijoSerie());
            detalleResumenResponse.setCodDetCat(n.getCodDetCat());
            detalleResumenResponse.setMoneda(n.getMoneda());
            detalleResumenResponse.setEstadoItem(n.getEstadoItem());
            detalleResumenResponseList.add(detalleResumenResponse);
        });

        datosResumenResponse.setEmpresa(empresaResponse);
        datosResumenResponse.setResumen(resumenResponse);
        datosResumenResponse.setDelleresumen(detalleResumenResponseList);

        return datosResumenResponse;
    }
}
