package cc.openhome.controller;

import cc.openhome.model.Bookmark;
import cc.openhome.model.BookmarkService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookmark extends HttpServlet {
    private String SUCCESS_VIEW = "success.view";
    private String ERROR_VIEW = "error.view";

    @Override
    public void init() throws ServletException {
        super.init();
        if(this.getInitParameter("SUCCESS") != null) {
            SUCCESS_VIEW = this.getInitParameter("SUCCESS");
        }
        if(this.getInitParameter("ERROR") != null) {
            ERROR_VIEW = this.getInitParameter("ERROR");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response)
                     throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String newCategory = request.getParameter("newCategory");

        List<String> errors = new ArrayList<String>();
        if (url == null || url.length() == 0) {
            errors.add("網址不能空白");
        }
        if (title == null || title.length() == 0) {
            errors.add("請輸入網頁標題");
        }
        if ((category == null || category.length() == 0) &&
            (newCategory == null || newCategory.length() == 0)) {
            errors.add("請設定網頁分類");
        }

        if (errors.size() != 0) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(ERROR_VIEW)
                    .forward(request, response);
        } else {
            url = url.trim();
            title = title.trim();
            if(newCategory != null) {
                newCategory = newCategory.trim();
                if(newCategory.length() != 0) {
                    category = newCategory;
                }
            }
            else {
                category = category.trim();
            }
            
            Bookmark bookmark = new Bookmark(url, title, category);

            BookmarkService bookmarkService = (BookmarkService)
                    getServletContext().getAttribute("bookmarkService");
            
            bookmarkService.addBookmark(bookmark);
            request.setAttribute("bookmark", bookmark);

            request.getRequestDispatcher(SUCCESS_VIEW)
                    .forward(request, response);
        }
    }
}
