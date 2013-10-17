package cc.openhome.controller;

import cc.openhome.model.Bookmark;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;

public class AddAction extends BookmarkActionSupport implements ModelDriven {
    private BookmarkForm bookmarkForm = new BookmarkForm();
    
    List<String> categories;
    
    @Override
    public String execute() throws Exception {
        String url = bookmarkForm.getUrl().trim();
        String title = bookmarkForm.getTitle().trim();
        String category = bookmarkForm.getCategory();
        if (bookmarkForm.getNewCategory() != null) {
            String newCategory = bookmarkForm.getNewCategory().trim();
            if (newCategory.length() != 0) {
                category = newCategory;
            }
        } 
        
        Bookmark bookmark = new Bookmark(url, title, category);
        getBookmarkService().addBookmark(bookmark);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (bookmarkForm.getUrl() == null || bookmarkForm.getUrl().length() == 0) {
            addFieldError("url", "網址不能空白");
        }
        if (bookmarkForm.getTitle() == null || bookmarkForm.getTitle().length() == 0) {
            addFieldError("title", "請輸入網頁標題");
        }
        if ((bookmarkForm.getCategory() == null || bookmarkForm.getCategory().length() == 0)
                && (bookmarkForm.getNewCategory() == null || bookmarkForm.getNewCategory().length() == 0)) {
            addFieldError("category", "請設定網頁分類");
        }
        if(!getFieldErrors().isEmpty()) {
            setCategories(getBookmarkService().getCategories());
        }
    }
    
    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Object getModel() {
        return bookmarkForm;
    }
    
    
}
