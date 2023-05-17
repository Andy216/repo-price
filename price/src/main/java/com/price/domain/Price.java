package com.price.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "price")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "price_list")
	private Long priceList;

	@Column(name = "brand_id")
	private Long brandId;

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "priority")
	private Long priority;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "curr")
	private String curr;
}
