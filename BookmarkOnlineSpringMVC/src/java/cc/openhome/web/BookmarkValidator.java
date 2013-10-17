package cc.openhome.web;

import cc.openhome.controller.BookmarkForm;
import cc.openhome.model.Bookmark;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookmarkValidator implements Validator {

    public boolean supports(Class type) {
        return type.equals(BookmarkForm.class);
    }

    public void validate(Object o, Errors errors) {
      
        BookmarkForm form = (BookmarkForm) o;
        if (form.getUrl() == null || form.getUrl().length() == 0) {
            errors.reject("url", "網址不能空白");
        }
        if (form.getTitle() == null || form.getTitle().length() == 0) {
            errors.reject("title", "請輸入網頁標題");
        }
        if ((form.getCategory() == null || form.getCategory().length() == 0) &&
                (form.getNewCategory() == null || form.getNewCategory().length() == 0)) {
            errors.reject("請設定網頁分類");
        }
    }
    
}
