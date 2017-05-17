<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String savePath = "C:/WebSite/project/hello/WebContent/img"; // 저장할 디렉토리 (절대경로)
	int sizeLimit = 10 * 1024 * 1024; // 10메가까지 제한 넘어서면 예외발생
	String img = "";
	String img2 = "";
	String img3 = "";
	String img4 = "";
	String originalFileName = "";
	try {
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames(); // 폼의 이름 반환
		
		String file = (String)files.nextElement();
		img = multi.getOriginalFileName(file);
		
		String file2 = (String)files.nextElement();
		img2 = multi.getOriginalFileName(file2);
		
		String file3 = (String)files.nextElement();
		img3 = multi.getOriginalFileName(file3);
		
		String file4 = (String)files.nextElement();
		img4 = multi.getOriginalFileName(file4);
		
		
	} catch (Exception e) {
		out.print("예외상황 발생");
	} //catch
%>
<%
Class.forName("com.mysql.jdbc.Driver");
try{
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testimage", "root", "1234");
	
	Statement stmt = conn.createStatement();
	
	String sql = "insert into image (path,path2,path3,path4) value ('img/"+img+"','img/"+img2+"','img/"+img3+"','img/"+img4+"')";
	
	stmt.executeUpdate(sql);
	
	
	stmt.close();
	conn.close();
	
	out.println("MySql jdbc test: connect ok!!");
}catch(SQLException ex){
	out.println(ex.getMessage());
}
%>
<html>
<head>
<script language="javascript">
	function delfile() {
		document.myform.action = './delup.jsp'
		document.myform.submit();
	}

	function down() {
		document.myform.action = './down.jsp'
		document.myform.submit();
	}
</script>
</head>
<body>
</body>

</html>