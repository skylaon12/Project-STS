package com.skylaon.spring.sm.vo;

import lombok.Data;

@Data
public class ProductVO {
	private int product_id;
	private String product_name;
	private String product_description;
	private int price;
	private String stock_quantity;
	private String image_url;
	private double rating;
	private int review_count;
}
