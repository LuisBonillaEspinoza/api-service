package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseGen {

	
	private String CodArt;    
    private String Nombre;
    private String PCosto;
    private String PVenta;
    private String StockMin;
    private double Stock;

	
}
