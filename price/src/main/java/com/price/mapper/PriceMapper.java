package com.price.mapper;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.StringUtils;

import com.price.domain.Price;
import com.price.dto.PriceRequestDTO;
import com.price.dto.PriceResponseDTO;
import com.price.util.PriceUtil;

@Mapper(componentModel = "spring")
public interface PriceMapper {

	@Mapping(target = "productId", source = "v.productId")
	@Mapping(target = "brandId", source = "v.brandId")
	@Mapping(target = "price", source = "v.price")
	@Mapping(target = "startDate", source = "v.startDate")
	@Mapping(target = "endDate", source = "v.endDate")
	PriceResponseDTO toDto(Price v);

	@Mapping(target = "productId", expression="java(asLong(v.getIdPro()))")
	@Mapping(target = "brandId", expression="java(asLong(v.getIdCad()))")
	@Mapping(target = "startDate", expression="java(asDate(v.getFecApp()))")
	Price toDomain(PriceRequestDTO v);

	default Long asLong(String value) {
		return StringUtils.hasLength(value)?Long.parseLong(value):null;
	}

	default Date asDate(String value) {
		return StringUtils.hasLength(value)? PriceUtil.toDate(value) :null;
	}
}
