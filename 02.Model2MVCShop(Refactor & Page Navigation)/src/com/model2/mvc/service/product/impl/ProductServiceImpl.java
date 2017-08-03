package com.model2.mvc.service.product.impl;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.domain.Product;


public class ProductServiceImpl implements ProductService{
	
	///Field
	private ProductDAO productDAO;
	
	//Constructor
	public ProductServiceImpl() {
		productDAO=new ProductDAO();
	}

	//Method
	public void addProduct(Product product) throws Exception {
		productDAO.insertProduct(product);
	}

	public Product getProduct(int productNo) throws Exception {
		return productDAO.findProduct(productNo);
	}

	public Map<String,Object> getProductList(Search search) throws Exception {
		return productDAO.getProductList(search);
	}

	public void updateProduct(Product product) throws Exception {
		productDAO.updateProduct(product);
	}
}