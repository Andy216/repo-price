package com.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.price.dto.PriceRequestDTO;
import com.price.dto.PriceResponseDTO;
import com.price.exceptions.ErrorException;
import com.price.service.PriceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/price")
@RequiredArgsConstructor
public class PriceController {

	@Autowired
	@Qualifier("priceService")
	private PriceService priceService;

	@GetMapping
	public ResponseEntity<PriceResponseDTO> get2(@RequestParam(required = false, value = "fecApp") String fecApp,
			@RequestParam(required = false, value = "idPro") String idPro,
			@RequestParam(required = false, value = "idCad") String idCad) throws ErrorException{

		return new ResponseEntity<>(
				priceService.getPrice(PriceRequestDTO.builder().fecApp(fecApp).idPro(idPro).idCad(idCad).build()),
				HttpStatus.OK);
	}

}
