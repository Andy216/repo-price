package com.price.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponseDTO {

	private Long productId;
	private Long brandId;
	private BigDecimal price;
	private Date startDate;
	private Date endDate;
}

