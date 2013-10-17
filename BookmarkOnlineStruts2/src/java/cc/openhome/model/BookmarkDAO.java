package cc.openhome.model;

import java.util.List;

public interface BookmarkDAO {
    void save(Bookmark bookmark);
    List<Bookmark> getAllBookmarks();
    List<String> getAllCategories();
}
