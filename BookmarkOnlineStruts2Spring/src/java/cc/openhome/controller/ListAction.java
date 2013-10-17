package cc.openhome.controller;

import cc.openhome.model.Bookmark;
import cc.openhome.model.BookmarkService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class ListAction extends BookmarkActionSupport {

    private List<Bookmark> bookmarks;

    @Override
    public String execute() throws Exception {
        setBookmarks(getBookmarkService().getBookmarks());
        return SUCCESS;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
