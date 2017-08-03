package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/////AddProductAction Action class execute start/////");
		
		Product product=new Product();
		product.setProdName(request.getParameter("prodName")); 
		//request ��ü�� �����ϴ� "prodName"��� name�� ������ value�� �̾Ƽ� product ��ü Field�� �����ϴ� ProdName���� set
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setManuDate(request.getParameter("manuDate"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
		
		System.out.println("product : "+product);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(product);
		
		request.setAttribute("product", product);
		// request ��ü�� jsp���� addProduct.jsp�� �Ѱ��ֱ� ���ؼ� product ��ü�� "product"��� �̸����� �Ӽ� setting
		
		System.out.println("/////AddProductAction Action class execute end : b4 return/////");
		
		return "forward:/product/addProduct.jsp";
	}
}