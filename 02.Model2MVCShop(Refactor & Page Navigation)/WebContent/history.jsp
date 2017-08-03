<%@ page contentType="text/html; charset=EUC-KR" %>

<html>
<head>
<title>열어본 상품 보기</title>
</head>

<body>
	당신이 열어본 상품을 알고 있다
<br>
<br>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	
	String history = null; // String type 의 history 값 null로 초기화
	
	Cookie[] cookies = request.getCookies(); //request로부터 cookie를 받아서(같은 이름을 가지는 cookie는 단 하나 존재) cookie를 담는 List 생성하여 cookies라는 참조변수 이름 선언
	
	if (cookies!=null && cookies.length > 0) { //위의 cookies라는 것이 null이 아니고, length가 0보다 크다면 : 이 의미는? 동일한 의미 아닌가...''?
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				history = cookie.getValue();
			}
		}
		if (history != null) { //위에서 선언된 String history가 null이 아니라면, 
			String[] h = history.split(","); //String 들을 담을 List인 h 생성하여 history를 , 기준으로 잘라서 h에 넣음.
			for (int i = 0; i < h.length; i++) {
				if (!h[i].equals("null")) {
%>
	<a href="/getProduct.do?prodNo=<%=h[i]%>&menu=search"	target="rightFrame"><%=h[i]%></a>
<br>
<%
				}
			}
		}
	}
%>

</body>
</html>