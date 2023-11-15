package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumenResponse {
    private String fecha;
    private String id;
    private String nDocResumen;
    private String archXml;
    private String nomArchXml;
    private String ticket;
}
