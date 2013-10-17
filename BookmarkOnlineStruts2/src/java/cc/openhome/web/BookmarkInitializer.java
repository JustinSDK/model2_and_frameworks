package cc.openhome.web;

import cc.openhome.model.BookmarkDAO;
import cc.openhome.model.BookmarkDAOImpl;
import cc.openhome.model.BookmarkService;
import javax.servlet.*;

public class BookmarkInitializer implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String bookmarkFile = context.getInitParameter("BOOKMARK");
        BookmarkDAO bookmarkDAO = new BookmarkDAOImpl( this.getClass().getClassLoader()
                    .getResource("../" + bookmarkFile).getFile());
        BookmarkService bookmarkService = new BookmarkService(bookmarkDAO);
        context.setAttribute("bookmarkService", bookmarkService);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
