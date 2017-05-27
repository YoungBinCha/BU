<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="java.io.*" %>

<%

String fileName = request.getParameter("fileName");

new File("C:/WebSite/project/hello/WebContent/img"+fileName).delete();

out.print("파일 삭제 완료!");

%>