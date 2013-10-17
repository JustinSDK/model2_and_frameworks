<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cc.openhome.model.*, java.util.*" %>
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

<%
    BookmarkService bookmarkService =
        (BookmarkService) application.getAttribute("bookmarkService");

    Iterator<Bookmark> bookmarks = bookmarkService.getBookmarks().iterator();
    while (bookmarks.hasNext()) {
        Bookmark bookmark = bookmarks.next();
%>
                <tr>
                    <td><a href="http://<%= bookmark.getUrl()%>">
                             <%= bookmark.getTitle()%></a></td>
                    <td><%= bookmark.getCategory()%></td>
                </tr>
<%
    }
%>
            </tbody>
        </table>
    </body>
</html>
