package com.skylaon.spring.sm.mapper;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.ProductVO;

public interface ProductMapper {
	public ArrayList<ProductVO> getProductList(int category_id);
	
	public ProductVO getProductInfo(int product_id);
	
	public ArrayList<ProductVO> getSearchProductList(String product_name);
}
