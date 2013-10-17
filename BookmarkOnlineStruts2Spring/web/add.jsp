<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>新增書籤</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            .errorMessage {
                color: red;
            }
        </style>
    </head>
    <body>
        <s:form action="add" method="post">
            <s:textfield label="網址" name="url"/>
            <s:textfield label="網頁名稱" name="title"/>
            <s:select  label="分類" name="category" 
                                list="categories"/>
            <s:textfield label="新增分類" name="newCategory"/>
            <s:submit label="送出"/>
        </s:form>
    </body>
</html>
