package com.skylaon.spring.sm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylaon.spring.sm.mapper.ProductMapper;
import com.skylaon.spring.sm.vo.ProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	@Override
	public ArrayList<ProductVO> getProductList(int id) {
		
		log.info("제품 service 진입");
		return mapper.getProductList(id);
	}

	@Override
	public ProductVO getProductInfo(int pro_id) {
		log.info("제품 info service 진입");
		return mapper.getProductInfo(pro_id);
	}

	@Override
	public ArrayList<ProductVO> getSearchProductList(String word) {
		log.info("검색 service 진입");
		return mapper.getSearchProductList(word);
	}
	
}
