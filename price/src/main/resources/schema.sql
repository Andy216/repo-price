create table price (
  brand_id integer ,
  start_date timestamp,
	end_date timestamp,
	price_list integer,
	product_id integer,
	priority integer,
	price numeric(20, 2),
	curr varchar(3) not null);