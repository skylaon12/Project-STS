package com.skylaon.spring.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skylaon.spring.sm.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/shop/*")
@AllArgsConstructor
@Controller
public class ShopController {
	private ProductService service;

	@RequestMapping("/category")
	public void category() {

	}

	@RequestMapping("/pdList")
	public void productList(int id, Model m) {
		log.info("컨트롤러진입");
		m.addAttribute("products", service.getProductList(id));
	}
	
	@RequestMapping("/search_pdList")
	public void searchProductList(@RequestParam("word") String word, Model m) {
		
		log.info("검색 컨트롤러 진입");
		log.info("검색어 : " + word);
		m.addAttribute("products", service.getSearchProductList(word));
	}

	@RequestMapping("/productInfo")
	public void productInfo(int p_id, Model m) {
		log.info(p_id);
		m.addAttribute("product", service.getProductInfo(p_id));
	}

}
