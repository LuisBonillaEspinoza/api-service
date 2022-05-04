package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.ArticuloStockDto;
import com.bicimoto.app.entity.Tblarticulo;
import com.bicimoto.app.entity.TblarticuloPK;
import com.bicimoto.app.entity.Tblstarticulo;
import com.bicimoto.app.entity.TblstarticuloPK;
import com.bicimoto.app.repository.ArticuloRepository;
import com.bicimoto.app.repository.ArticuloStRepository;
import com.bicimoto.app.request.ArticuloRequest;
import com.bicimoto.app.response.ArticuloStockResponse;
import com.bicimoto.app.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloStRepository articuloStRepository;

    @Override
    @Transactional(readOnly = true)
    public ArticuloStockResponse findConsultaSotck(String codArti, String codAlmacen, String codEmpresa) throws Exception {

        ArticuloStockResponse response = new ArticuloStockResponse();
        ArticuloStockDto articuloStockDto = articuloStRepository.findArticuloStock(codArti, codAlmacen, codEmpresa);

        if (articuloStockDto==null) {
            throw new Exception("No existen datos registrados");
        }

        response.setCodArti(articuloStockDto.getCodArti());
        response.setNombre(articuloStockDto.getNombre());
        response.setCodAlm(articuloStockDto.getCodAlm());
        response.setNomAlm(articuloStockDto.getNomAlm());
        response.setRucEmpresa(articuloStockDto.getRucEmpresa());
        response.setStock(articuloStockDto.getStock());

        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ArticuloRequest> saveDataUpload(List<ArticuloRequest> listaArticuloRequest) throws ParseException {

        for (ArticuloRequest request : listaArticuloRequest) {

            Date fechaActual = new Date();

            Tblarticulo tblArticulo = new Tblarticulo();

            ArticuloStockDto tblArticuloExiste = articuloStRepository.findArticuloStock(request.getCodArt(),request.getAlmacen(), request.getRucEmpresa());

            TblarticuloPK pk = new TblarticuloPK();

            pk.setCod_art(request.getCodArt());
            pk.setRucEmpresa(request.getRucEmpresa());
            pk.setAlmacen(request.getAlmacen());

            tblArticulo.setId(pk);

            tblArticulo.setCantPrecioVolum(request.getCantPrecioVolum());
            tblArticulo.setCodFamilia(request.getCodFamilia());
            tblArticulo.setCodInternac(request.getCodInternac());
            tblArticulo.setCodLinea(request.getCodLinea());
            tblArticulo.setCodLinea(request.getCodLinea());
            tblArticulo.setCodMarca(request.getCodMarca());
            tblArticulo.setCodModelo(request.getCodModelo());
            tblArticulo.setCodProced(request.getCodProced());
            tblArticulo.setCodUnidad(request.getCodUnidad());
            tblArticulo.setDescricpcion(request.getDescricpcion());
            tblArticulo.setEst(request.getEst());
            tblArticulo.setFecCreacion(fechaActual);
            tblArticulo.setGenStock(request.getGenStock());
            tblArticulo.setIsVehiculo(request.getIsVehiculo());
            tblArticulo.setNombre(request.getNombre());
            tblArticulo.setPAraNac(request.getPAraNac());
            tblArticulo.setParNab(request.getPAraNac());
            tblArticulo.setPcif(request.getPcif());
            tblArticulo.setPCosto(request.getPCosto());
            tblArticulo.setPfob(request.getPfob());
            tblArticulo.setPMayorista(request.getPMayorista());
            tblArticulo.setPromedioVenta(request.getPromedioVenta());
            tblArticulo.setProveedor(request.getProveedor());
            tblArticulo.setPVenta(request.getPVenta());
            tblArticulo.setPVolumen(request.getPVolumen());
            tblArticulo.setStockMin(request.getStockMin());
            tblArticulo.setStockReal(request.getStockReal());
            tblArticulo.setTipMoneda(request.getTipMoneda());
            tblArticulo.setTipProducto(request.getTipProducto());
            tblArticulo.setTSerie(request.getTSerie());
            tblArticulo.setUbicacion(request.getUbicacion());
            tblArticulo.setUserCreacion(request.getUserCreacion());
            tblArticulo.setVentaMin(request.getVentaMin());
            articuloRepository.save(tblArticulo);

            if (tblArticuloExiste == null) {
                Tblstarticulo tblStArticulo = new Tblstarticulo();

                TblstarticuloPK pk1 = new TblstarticuloPK();
                pk1.setCodArti(request.getCodArt());
                pk1.setCodAlm(request.getAlmacen());
                pk1.setRuc(request.getRucEmpresa());
                tblStArticulo.setId(pk1);
                tblStArticulo.setStock(0);
                tblStArticulo.setFecCreacion(fechaActual);
                tblStArticulo.setUserCreacion(request.getUserCreacion());
                articuloStRepository.save(tblStArticulo);
            }

        }

        return listaArticuloRequest;
    }

}
