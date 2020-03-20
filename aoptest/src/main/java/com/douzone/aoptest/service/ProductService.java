package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVO;

@Service
public class ProductService {
	public ProductVO find(String name) {
		System.out.println("[ProductService finding....]");
//		if(1-1 == 0) {
//			throw new RuntimeException("Fing Exception");
//		}
		return new ProductVO(name);
	}
}
