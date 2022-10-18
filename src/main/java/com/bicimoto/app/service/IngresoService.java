package com.bicimoto.app.service;

import com.bicimoto.app.request.IngresoRequest;

public interface IngresoService {
    IngresoRequest saveGuiaRemision(IngresoRequest request, String id) throws Exception;
}
