package cc.openhome.controller;

import cc.openhome.model.BookmarkService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BookmarkActionSupport extends ActionSupport {
    private BookmarkService bookmarkService;    

    public BookmarkService getBookmarkService() {
//        if(bookmarkService == null) {
//            WebApplicationContext ctx = WebApplicationContextUtils.
//                getRequiredWebApplicationContext(ServletActionContext.getServletContext());
//                bookmarkService = (BookmarkService) ctx.getBean("bookmarkService");
//        }
        return bookmarkService;
    }

    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

}
