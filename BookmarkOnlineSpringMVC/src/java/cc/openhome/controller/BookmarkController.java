package cc.openhome.controller;

import cc.openhome.model.Bookmark;
import cc.openhome.model.BookmarkService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BookmarkController extends MultiActionController {
    private BookmarkService bookmarkService;    
    
    public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
        List<Bookmark> bookmarks = getBookmarkService().getBookmarks();
        return new ModelAndView("list", "bookmarks", bookmarks);
    }
    
    public ModelAndView addForm(HttpServletRequest request,HttpServletResponse response) {
        List<String> categories = getBookmarkService().getCategories();
        return new ModelAndView("add", "categories", categories);
    }
    
    public ModelAndView add(HttpServletRequest request,HttpServletResponse response, BookmarkForm form) {
        String category = form.getCategory();
        if(form.getNewCategory() != null && form.getNewCategory().trim().length() != 0) {
            category = form.getNewCategory().trim();
        }
        
        Bookmark bookmark = new Bookmark(form.getUrl().trim(), form.getTitle().trim(), category);
        getBookmarkService().addBookmark(bookmark);

        return new ModelAndView("success", "bookmark", form);
    }
    
    public ModelAndView validationFailed(HttpServletRequest request, HttpServletResponse response, ServletRequestBindingException ex) {
         BindException bex = (BindException) ex.getCause(); 
         
         List<String> errors = new ArrayList<String>();
         for(Object o : bex.getGlobalErrors()) {
             ObjectError oe = (ObjectError) o;
             errors.add(oe.getDefaultMessage());
         }
         
         List<String> categories = getBookmarkService().getCategories();
         Map<String, Object> model = new HashMap<String, Object>();
        
         model.put("errors", errors);
         model.put("categories", categories);
        
         return new ModelAndView("add", model);
    }
    
    public BookmarkService getBookmarkService() {
        return bookmarkService;
    }

    public void setBookmarkService(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }
}
