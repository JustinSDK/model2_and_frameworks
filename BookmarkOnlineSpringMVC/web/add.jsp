<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>新增書籤</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:if test="${requestScope.errors != null}">
            <h1>新增書籤失敗</h1>
            <ul style="color: rgb(255, 0, 0);">
                <c:forEach var="error" items="${requestScope.errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
        <form method="post" action="bookmarks">
            <input type="hidden" name="action" value="add">
            網址&nbsp;http:// <input name="url" value="${param.url}"><br>
            網頁名稱：<input name="title" value="${param.title}"><br>
            分　　類：<select name="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category}">${category}</option>
                </c:forEach>
            </select>
            新增分類：<input type="text" name="newCategory" value=""><br>
            
            <input value="送出" type="submit"><br>
        </form>
    </body>
</html>
