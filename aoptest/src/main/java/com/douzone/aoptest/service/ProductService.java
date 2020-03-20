package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVO;

@Service
public class ProductService {
	public ProductVO find(String name) {
		System.out.println("[ProductService finding....]");
		return new ProductVO(name);
	}
}
