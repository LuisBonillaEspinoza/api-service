package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.DatosScheduleDTO;
import com.bicimoto.app.dto.DetVentaDTO;
import com.bicimoto.app.repository.DatosScheduleRepository;
import com.bicimoto.app.response.*;
import com.bicimoto.app.service.DatosScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DatosScheduleServiceImpl implements DatosScheduleService {

    @Autowired
    private DatosScheduleRepository datos;

    @Override
    public DatosResponse getDatosScheduler(String TipoDocumento, String Numero, String Serie, String Ruc, String Almacen){
        DatosResponse response = new DatosResponse();

        DatosScheduleDTO datosdto = datos.BuscarDatosSchedule(Ruc,Numero,Serie,TipoDocumento,Almacen);

        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setRazon(datosdto.getRazon());
        empresaResponse.setNombreLegal(datosdto.getNombreLegal());
        empresaResponse.setUbigeo(datosdto.getUbigeo());
        empresaResponse.setDireccion(datosdto.getDireccion());
        empresaResponse.setUrbanizacion(datosdto.getUrbanizacion());
        empresaResponse.setTelefono(datosdto.getTelefono());
        empresaResponse.setCelular(datosdto.getCelular());
        empresaResponse.setRepresentante(datosdto.getRepresentante());
        empresaResponse.setEmail(datosdto.getEmail());
        empresaResponse.setTelefono2(datosdto.getTelefono2());
        empresaResponse.setNombreRegion(datosdto.getNombreRegion());
        empresaResponse.setNombreProvincia(datosdto.getNombreProvincia());
        empresaResponse.setNombreDistrito(datosdto.getNombreDistrito());

        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setNombre(datosdto.getNombreCliente());
        clienteResponse.setEmail(datosdto.getEmailCliente());
        clienteResponse.setCodigo(datosdto.getCodCliente());

        VentaResponse ventaResponse = new VentaResponse();
        ventaResponse.setNombreMoneda(datosdto.getTMoneda());
        ventaResponse.setIdventa(datosdto.getIdVenta());
        ventaResponse.setFecha(datosdto.getFecha());
        ventaResponse.setNombredoc(datosdto.getDoc());
        ventaResponse.setCodDoc(datosdto.getCodDoc());
        ventaResponse.setNomArchXml(datosdto.getNomArchXml());
        ventaResponse.setArchXml(datosdto.getArchivoXml());
        ventaResponse.setUsuario(datosdto.getUsuario());
        ventaResponse.setTipoDocCliente(datosdto.getTipDocCli());
        ventaResponse.setTipoCompra(datosdto.getTComp());
        ventaResponse.setDcto(datosdto.getDcto());
        ventaResponse.setTBruto(datosdto.getTBruto());
        ventaResponse.setTExonerada(datosdto.getTExonerada());
        ventaResponse.setTInafectada(datosdto.getTInafecta());
        ventaResponse.setTGratuita(datosdto.getTGratuita());
        ventaResponse.setTIgv(datosdto.getTIgv());
        ventaResponse.setEGratuita(datosdto.getEGratuita());
        ventaResponse.setTotal(datosdto.getTotal());
        ventaResponse.setTventa(datosdto.getTVenta());
        ventaResponse.setSerie(datosdto.getSerie());
        ventaResponse.setPrefijoSerie(datosdto.getPrefijoSerie());
        ventaResponse.setNumero(datosdto.getNumero());
        ventaResponse.setCodtcomp(datosdto.getCodTComp());

        List<DetVentaDTO> detVentaDTO = datos.BuscarDetVenta(datosdto.getIdVenta(),Ruc,Almacen);
        List<DetalleVentaResponse> detalleVentaResponseList = new ArrayList<>();
        final int[] id = {1};
        detVentaDTO.stream().forEach(n->{
            DetalleVentaResponse detalleVentaResponse = new DetalleVentaResponse();
            detalleVentaResponse.setId(String.valueOf(id[0]));
            detalleVentaResponse.setCodArt(n.getCodArt());
            detalleVentaResponse.setDescripcion(n.getDescripcion());
            detalleVentaResponse.setPUnitario(n.getPUnitario());
            detalleVentaResponse.setPReferencial(n.getPReferencial());
            detalleVentaResponse.setTipPrecio(n.getTipPrecio());
            detalleVentaResponse.setDcto(n.getDcto());
            detalleVentaResponse.setCantidad(n.getCantidad());
            detalleVentaResponse.setIgv(n.getIgv());
            detalleVentaResponse.setTipoImpuesto(n.getTipoImpuesto());
            detalleVentaResponse.setImporte(n.getTotalVenta());
            detalleVentaResponse.setUnidadMedida("NIU");
            detalleVentaResponse.setTotalVenta(n.getTotalVenta());
            detalleVentaResponseList.add(detalleVentaResponse);
            id[0] = id[0] + 1;
        });

        response.setEmpresa(empresaResponse);
        response.setCliente(clienteResponse);
        response.setVenta(ventaResponse);
        response.setDetalleVenta(detalleVentaResponseList);

        return response;
    }
}
