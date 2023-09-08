package com.skylaon.spring.sm.service;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.ProductVO;

public interface ProductService {
	public ArrayList<ProductVO> getProductList(int id);
	
	public ProductVO getProductInfo(int pro_id);
	
	public ArrayList<ProductVO> getSearchProductList(String word);
}
