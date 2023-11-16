package com.bicimoto.app.controller;

import com.bicimoto.app.request.ArticuloRequest;
import com.bicimoto.app.response.ArticuloStockResponse;
import com.bicimoto.app.response.ProductoResponse;
import com.bicimoto.app.response.ProductoResponseGen;
import com.bicimoto.app.service.ArticuloService;
import com.bicimoto.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/articulo")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;

	@GetMapping()
	public ResponseEntity<?> consultaProducto() {
		List<ProductoResponseGen> response = new ArrayList<>();

		try {
			response = articuloService.findProductos();
		} catch (Exception e) {
			return buildResponseError(Constants.MensajeExcepcion, e);
		}
		if (response == null) {
			return buildResponseError(Constants.MensajeErrorNulo, null);
		}
		return new ResponseEntity<List<ProductoResponseGen>>(response, HttpStatus.OK);
	}

	@GetMapping("/consulta/stock")
	public ResponseEntity<?> consultaStock(@RequestParam Map<String, String> params) {

		ArticuloStockResponse response = null;

		try {

			response = articuloService.findConsultaSotck((params.get("codigo") != null ? params.get("codigo") : null),
					(params.get("almacen") != null ? params.get("almacen") : null),
					(params.get("empresa") != null ? params.get("empresa") : null));

		} catch (Exception e) {
			return buildResponseError(Constants.MensajeExcepcion, e);
		}

		if (response == null) {
			return buildResponseError(Constants.MensajeErrorNulo, null);
		}

		return new ResponseEntity<ArticuloStockResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<?> consultaProductoId(@RequestParam String codigo) {

		List<ProductoResponse> response = null;

		try {
			response = articuloService.findProductosByID(codigo);

		} catch (Exception e) {
			return buildResponseError(Constants.MensajeExcepcion, e);
		}

		if (response == null) {
			return buildResponseError(Constants.MensajeErrorNulo, null);
		}

		return new ResponseEntity<List<ProductoResponse>>(response, HttpStatus.OK);
	}

	@PostMapping("/add/upload")
	public ResponseEntity<?> saveListArticulo(@RequestBody List<ArticuloRequest> request) throws Exception {

		List<ArticuloRequest> newArticulo = new ArrayList<>();

		try {
			newArticulo = articuloService.saveDataUpload(request);
		} catch (Exception e) {
			return buildResponseError(Constants.MensajeErrorRegistro, e);
		}

		Map<String, Object> response = new HashMap<>();
		response.put(Constants.Mensaje, Constants.MensajeAceptadoRegistro);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	private ResponseEntity<Map<String, Object>> buildResponseError(String error, Exception exception) {
		Map<String, Object> response = new HashMap<>();

		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		if (exception != null) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			if (exception.getMessage() != null) {
				error = exception.getMessage();
			}
		}
		response.put(Constants.Mensaje, error);
		return new ResponseEntity<Map<String, Object>>(response, httpStatus);
	}

}
