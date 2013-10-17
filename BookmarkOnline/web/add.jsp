<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, cc.openhome.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>新增書籤</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
<%
    List errorList = (List) request.getAttribute("errors");
    if (errorList != null) {
%>
        <h1>新增書籤失敗</h1>
        <ul style="color: rgb(255, 0, 0);">
<%
        Iterator<String> errors = errorList.iterator();
        while (errors.hasNext()) {
            out.println("<li>" + errors.next() + "</li>");
        }
        out.println("</ul>");
    }
%>

        <form method="post" action="add.do">
            網址&nbsp;http:// <input name="url" value="${param.url}"><br>
            網頁名稱：<input name="title" value="${param.title}"><br>
            分　　類：<select name="category">
<%
    BookmarkService bookmarkService = (BookmarkService)
            application.getAttribute("bookmarkService");
    Iterator<String> iterator =
            bookmarkService.getCategories().iterator();
    while (iterator.hasNext()) {
        String category = iterator.next();
%>
            <option value="<%= category %>"><%= category %></option>
<%
        
    }
%>
            </select>
            新增分類：<input type="text" name="newCategory" value=""><br>
            <input value="送出" type="submit"><br>
        </form>
    </body>
</html>
