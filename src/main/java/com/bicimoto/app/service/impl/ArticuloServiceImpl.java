package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.ArticuloStockDto;
import com.bicimoto.app.repository.ArticuloRepository;
import com.bicimoto.app.repository.ArticuloStRepository;
import com.bicimoto.app.response.ArticuloStockResponse;
import com.bicimoto.app.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloStRepository articuloStRepository;

    @Override
    @Transactional(readOnly = true)
    public ArticuloStockResponse findConsultaSotck(String codArti, String codAlmacen, String codEmpresa) throws Exception {

        //ArticuloStockDto articuloStockDto = null;
        ArticuloStockResponse response = new ArticuloStockResponse();
        ArticuloStockDto articuloStockDto = articuloStRepository.findArticuloStock(codArti, codAlmacen, codEmpresa);

        if (articuloStockDto==null) {
            throw new Exception("No existen datos registrados");
        }

        response.setCodArti(articuloStockDto.getCodArti());
        response.setNombre(articuloStockDto.getNombre());
        response.setCodAlm(articuloStockDto.getCodAlm());
        response.setRucEmpresa(articuloStockDto.getRucEmpresa());
        response.setStock(articuloStockDto.getStock());

        return response;
    }

}
