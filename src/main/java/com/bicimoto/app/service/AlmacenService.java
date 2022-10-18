package com.bicimoto.app.service;

import com.bicimoto.app.dto.AlmacenDto;


import java.util.List;

public interface AlmacenService {

    List<AlmacenDto> findAlmacens() throws Exception;

}
