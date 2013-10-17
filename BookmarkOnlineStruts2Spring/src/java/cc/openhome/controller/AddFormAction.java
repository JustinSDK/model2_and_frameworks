package cc.openhome.controller;

import cc.openhome.model.BookmarkService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.ServletActionContext;

public class AddFormAction extends BookmarkActionSupport {
    private List<String> categories;
    
    @Override
    public String execute() throws Exception {
        setCategories(getBookmarkService().getCategories());
        return SUCCESS;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
}
