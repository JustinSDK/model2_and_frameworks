<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>新增書籤成功</title>
    </head>
    <body>
        <h1>新增書籤成功</h1>
        <ul>
            <li>網址：http:// ${requestScope.bookmark.url} </li>
            <li>名稱：${requestScope.bookmark.title}</li>
            <li>分類：${requestScope.bookmark.category}</li>
        </ul>
        <a href="index.html">回首頁</a>
    </body>
</html>
