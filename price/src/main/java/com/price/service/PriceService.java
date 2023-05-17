package com.price.service;

import com.price.dto.PriceRequestDTO;
import com.price.dto.PriceResponseDTO;
import com.price.exceptions.ErrorException;

public interface PriceService {

	public abstract PriceResponseDTO getPrice(PriceRequestDTO obj) throws ErrorException;
}
