package com.price.service.impl;

import java.util.Comparator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.price.domain.Price;
import com.price.dto.PriceRequestDTO;
import com.price.dto.PriceResponseDTO;
import com.price.exceptions.ErrorException;
import com.price.mapper.PriceMapper;
import com.price.repository.PriceRepository;
import com.price.service.PriceService;
import com.price.util.PriceUtil;

import lombok.extern.log4j.Log4j2;

@Service("priceService")
@Log4j2
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	@Qualifier("priceRepository")
	private PriceRepository priceRepository;

	@Autowired
	private PriceMapper priceMapper;

	public PriceResponseDTO getPrice(PriceRequestDTO obj) throws ErrorException {

		if (this.validateRequest(obj)) {

			Optional<Price> res = priceRepository.findCustom(priceMapper.toDomain(obj)).stream()
					.sorted(Comparator.comparing(Price::getPriority).reversed()).findFirst();

			if (res.isPresent()) {
				return priceMapper.toDto(res.get());
			}

			throw new ErrorException("No data found");
		}
		throw new ErrorException();
	}

	private Boolean validateRequest(PriceRequestDTO obj) {

		Boolean ret = Boolean.TRUE;

		log.info(obj.toString());

		if (StringUtils.hasLength(obj.getFecApp()) && !PriceUtil.validateDate(obj.getFecApp())) {
			ret = Boolean.FALSE;
		}

		if (StringUtils.hasLength(obj.getIdPro()) && !PriceUtil.validateNumber(obj.getIdPro())) {
			ret = Boolean.FALSE;
		}

		if (StringUtils.hasLength(obj.getIdCad()) && !PriceUtil.validateNumber(obj.getIdCad())) {
			ret = Boolean.FALSE;
		}

		return ret;
	}

}
