package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComBajaResponse {
    private String fecha;
    private String id;
    private String nDocBaja;
    private String archXml;
    private String nomArchXml;
    private String ticket;
}
