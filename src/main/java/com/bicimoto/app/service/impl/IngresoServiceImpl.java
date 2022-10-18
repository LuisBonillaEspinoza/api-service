package com.bicimoto.app.service.impl;

import com.bicimoto.app.entity.Tbldetingreso;
import com.bicimoto.app.entity.TbldetingresoPK;
import com.bicimoto.app.entity.Tblingreso;
import com.bicimoto.app.repository.ArticuloStRepository;
import com.bicimoto.app.repository.IngresoRepository;
import com.bicimoto.app.repository.DetalleIngresoRepository;
import com.bicimoto.app.request.IngresoRequest;
import com.bicimoto.app.service.IngresoService;
import com.bicimoto.app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class IngresoServiceImpl implements IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private DetalleIngresoRepository detalleRepository;

    @Autowired
    private ArticuloStRepository articuloStRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public IngresoRequest saveGuiaRemision(IngresoRequest request, String id) throws Exception {

        Date fechaActual = new Date();
        Date fecha = Utils.convertirStringFecha(request.getFecha(), "yyyy-MM-dd");
        Tblingreso tblingreso = new Tblingreso();

        tblingreso.setId(request.getId());
        tblingreso.setFecha(fecha);
        tblingreso.setTipDoc(request.getTipDoc());
        tblingreso.setConcepto(request.getConcepto());
        tblingreso.setSerie(request.getSerie());
        tblingreso.setNumero(request.getNumero());
        tblingreso.setReferencia(request.getReferencia());
        tblingreso.setResponsable(request.getResponsable());
        tblingreso.setAlmacen(request.getAlmacen());
        tblingreso.setEmpresa(request.getEmpresa());
        tblingreso.setEst(request.getEst());
        if(id != null){
            tblingreso.setUserModi(request.getUserCreacion());
            tblingreso.setFecModi(fechaActual);
            articuloStRepository.devolverStock(request.getId(), "INGRESO", request.getEmpresa(), request.getAlmacen());
            detalleRepository.detIngresoElimina(request.getId(), request.getEmpresa(), request.getAlmacen());
        } else {
            tblingreso.setUserCreacion(request.getUserCreacion());
            tblingreso.setFecCreacion(fechaActual);
        }

        ingresoRepository.save(tblingreso);

        for(IngresoRequest.DetalleIngresoRequest detalleSalidaRequest : request.getListaDetalle()){
            Tbldetingreso tbldetingreso = new Tbldetingreso();
            TbldetingresoPK pk = new TbldetingresoPK();

            pk.setId(detalleSalidaRequest.getId());
            pk.setCodigo(detalleSalidaRequest.getCodigo());
            pk.setCantidad(detalleSalidaRequest.getCantidad());
            pk.setAlmacen(detalleSalidaRequest.getAlmacen());
            pk.setEmpresa(detalleSalidaRequest.getEmpresa());
            pk.setFecCreacion(fechaActual);

            tbldetingreso.setId(pk);
            tbldetingreso.setMarca(detalleSalidaRequest.getMarca());
            tbldetingreso.setProced(detalleSalidaRequest.getProced());
            tbldetingreso.setUnidad(detalleSalidaRequest.getUnidad());
            tbldetingreso.setUserCreacion(detalleSalidaRequest.getUserCreacion());

            detalleRepository.save(tbldetingreso);

            //Actualiza Stock
            articuloStRepository.updateIngStock(detalleSalidaRequest.getEmpresa(), detalleSalidaRequest.getAlmacen(),
                    detalleSalidaRequest.getCodigo(), detalleSalidaRequest.getCantidad(), detalleSalidaRequest.getUserCreacion());
        }
        return request;
    }

}
