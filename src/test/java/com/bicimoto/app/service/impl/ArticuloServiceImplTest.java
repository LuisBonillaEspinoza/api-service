package com.bicimoto.app.service.impl;

import com.bicimoto.app.dto.ProductoDto;
import com.bicimoto.app.repository.ArticuloRepository;
import com.bicimoto.app.service.ArticuloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ArticuloServiceImplTest {
    ArticuloRepository articuloRepository;
    ArticuloService articuloService;

    @BeforeEach
    void setUp(){
        articuloRepository = mock(ArticuloRepository.class);
        articuloService = new ArticuloServiceImpl();
    }

    @Test
    void findProductos() {
        when(articuloRepository.findProductos());
    }
}