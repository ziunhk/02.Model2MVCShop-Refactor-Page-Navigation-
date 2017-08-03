package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession; ���⿡ session�� �ʿ��ֳ�?

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/////UpdateProductAction class execute start/////");

		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		System.out.println("prodNo : "+prodNo);//
		
		Product product=new Product();
		product.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setManuDate(request.getParameter("manuDate"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
		
		ProductService productService=new ProductServiceImpl(); // regData�� null �̹Ƿ� DAO�� �߻�ȭ�� Service instance �����Ͽ� �ҷ��´�.
		productService.updateProduct(product); // updateProduct�Ŀ� �� service instance�� �������.
		
		//HttpSession session = request.getSession();
		//int sessionNo = ((Product)session.getAttribute("product")).getProdNo();
		
		//System.out.println("UpdateProductAction���� sessionNo : "+sessionNo);
		
		//if(sessionNo == prodNo){
			//session.setAttribute("product", product);
		//}
		
		request.setAttribute("vo", productService.getProduct(prodNo));
		
		System.out.println("/////UpdateProductAction class execute end : b4 return"); 
		
		return "forward:/product/getProduct.jsp?prodNo="+prodNo+"&menu=manage";
	}
}