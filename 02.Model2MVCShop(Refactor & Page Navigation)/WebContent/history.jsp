<%@ page contentType="text/html; charset=EUC-KR" %>

<html>
<head>
<title>��� ��ǰ ����</title>
</head>

<body>
	����� ��� ��ǰ�� �˰� �ִ�
<br>
<br>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	
	String history = null; // String type �� history �� null�� �ʱ�ȭ
	
	Cookie[] cookies = request.getCookies(); //request�κ��� cookie�� �޾Ƽ�(���� �̸��� ������ cookie�� �� �ϳ� ����) cookie�� ��� List �����Ͽ� cookies��� �������� �̸� ����
	
	if (cookies!=null && cookies.length > 0) { //���� cookies��� ���� null�� �ƴϰ�, length�� 0���� ũ�ٸ� : �� �ǹ̴�? ������ �ǹ� �ƴѰ�...''?
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				history = cookie.getValue();
			}
		}
		if (history != null) { //������ ����� String history�� null�� �ƴ϶��, 
			String[] h = history.split(","); //String ���� ���� List�� h �����Ͽ� history�� , �������� �߶� h�� ����.
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