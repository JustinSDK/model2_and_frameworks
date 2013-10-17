package cc.openhome.model;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class BookmarkService {
    private List<Bookmark> bookmarks;
    private List<String> categories;
    private BookmarkDAO bookmarkDAO;

    public BookmarkService(BookmarkDAO bookmarkDAO) {
        this.bookmarkDAO = bookmarkDAO;
        bookmarks = bookmarkDAO.getAllBookmarks();
        categories = bookmarkDAO.getAllCategories();
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Bookmark> addBookmark(Bookmark bookmark) {
        this.bookmarkDAO.save(bookmark);
        this.getBookmarks().add(bookmark);
        if (!categories.contains(bookmark.getCategory())) {
            categories.add(bookmark.getCategory());
        }
        return this.getBookmarks();
    }
}
