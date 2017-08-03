package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;


public class GetProductAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/////GetProductAction class execute start/////");
		
		String menu = request.getParameter("menu"); // request��ü�� ������ "menu"�� �̸��� ������ value���� String menu�� ����
		System.out.println("get product action ���� request.getParameter menu : "+menu);
		int productNo=Integer.parseInt(request.getParameter("prodNo")); //"prodNo"�̸��� ������ parameter�� request��ü�κ��� �ҷ��ͼ� Integer�� ������� ��, productNo�� ����.
		System.out.println("productNo : "+productNo);
		
		ProductService service=new ProductServiceImpl(); 
		//service ��� �̸��� ������ ProductService ��ü�� ���� : ProductServiceImpl(������ ������ ProductServiceImpl�� �޼ҵ带 �� ����)
		Product vo=service.getProduct(productNo);
		
		request.setAttribute("vo", vo); //request ��ü�� "vo" ��� �̸����� vo �Ӽ��ο�
				
		System.out.println("GetProductAction ���� setAttribute �� vo : "+vo);
		System.out.println("get product action if �� ����");
		
		if(menu.equals("manage")){
			System.out.println("/////AddProductAction Action class execute end : b4 return/////");
			return "forward:/updateProductView.do";
		}else{
			System.out.println("/////AddProductAction Action class execute end : b4 return/////");
			
			//manage�� ���� �ʿ� ���� : ��Ű����Ʈ? �� ���Ӱ� ������� ��Ű�� �־ history.jsp���� ��θ� ��¿���
			Cookie[] cookies = request.getCookies(); //request ��ü�κ��� ��Ű�� �޾Ƽ� Cookies[] data type�� cookies ��� ���������� ����
			Cookie cookie = null; // Cookie data type�� cookie instance �����ϰ� �ʱⰪ null
			for(int i = 0; i < cookies.length; i++){ //cookies��� list�� �����ϴ� ��� cookie�鿡 ���Ͽ� 
				if(cookies[i].getName().equals("history")){ // cookies[]�� ������ cookie �̸��� "history"��� name�� ������ cookie�� �����Ѵٸ�
					cookie = cookies[i];
					cookie.setValue(cookies[i].getValue()+","+productNo); // �� cookie�� history ��� �̸��� ���� cookie ��ü�� �����Ѵ�.
					cookie.setMaxAge(60*10); //��Ű�� �Ҹ꿹���ð� 10��
				}
			}
			
			if(cookie == null){ //for���� �� ������ ��� cookie�� �˻��ص� history �̸��� ���� cookie�� �������� �ʴ´ٸ�,
				cookie = new Cookie("history", ""+productNo); //
				cookie.setMaxAge(60*10);
			}
			response.addCookie(cookie);
			
			
			return "forward:/product/getProduct.jsp?productNo"+productNo;
		}
	}//end of execute
}