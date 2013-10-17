package cc.openhome.controller;

import cc.openhome.model.Bookmark;
import cc.openhome.model.BookmarkService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class AddAction extends ActionSupport {
    String url;
    String title;
    String category;
    String newCategory;

    @Override
    public String execute() throws Exception {
        url = url.trim();
        title = title.trim();
        if (newCategory != null) {
            newCategory = newCategory.trim();
            if (newCategory.length() != 0) {
                category = newCategory;
            }
        } else {
            category = category.trim();
        }

        Bookmark bookmark = new Bookmark(url, title, category);
        BookmarkService bookmarkService = 
                (BookmarkService) ServletActionContext.getServletContext()
                                                      .getAttribute("bookmarkService");
        bookmarkService.addBookmark(bookmark);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (url == null || url.length() == 0) {
            addFieldError("url", "網址不能空白");
        }
        if (title == null || title.length() == 0) {
            addFieldError("title", "請輸入網頁標題");
        }
        if ((category == null || category.length() == 0)
                && (newCategory == null || newCategory.length() == 0)) {
            addFieldError("category", "請設定網頁分類");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String newCategory) {
        this.newCategory = newCategory;
    }
}
