<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>觀看線上書籤</title>
    </head>
    <body>
        <table style="text-align: left; width: 100%;" border="0">
            <tbody>
                <tr>
                    <td style="background-color: rgb(51, 255, 255);">網頁</td>
                    <td style="background-color: rgb(51, 255, 255);">分類</td>
                </tr>
                <s:iterator var="bookmark" value="bookmarks">
                    <tr>
                        <td><a href="http://<s:property value="#bookmark.url"/>">
                             <s:property value="#bookmark.title"/></a></td>
                        <td><s:property value="#bookmark.category"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
