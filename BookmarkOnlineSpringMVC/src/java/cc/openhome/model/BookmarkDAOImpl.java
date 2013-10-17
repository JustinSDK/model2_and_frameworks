package cc.openhome.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookmarkDAOImpl implements BookmarkDAO {
    private String filename;

    public BookmarkDAOImpl(String filename) {
        this.filename = filename;
    }

    public void save(Bookmark bookmark) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                          new FileOutputStream(filename, true), "UTF-8"));
            writer.write(bookmark.getUrl() + "," + bookmark.getTitle() +
                    "," + bookmark.getCategory()
                        + System.getProperty("line.separator"));
        } catch (IOException ex) {
            Logger.getLogger(BookmarkService.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(BookmarkService.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Bookmark> getAllBookmarks() {
        BufferedReader reader = null;
        List<Bookmark> bookmarks = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(filename), "UTF-8"));
            bookmarks = new LinkedList<Bookmark>();
            String input = null;
            while ((input = reader.readLine()) != null) {
                String[] tokens = input.split(",");
                Bookmark bookmark =
                        new Bookmark(tokens[0], tokens[1], tokens[2]);
                bookmarks.add(bookmark);
            }
        } catch (IOException ex) {
            Logger.getLogger(BookmarkService.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(BookmarkService.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return bookmarks;
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<String>();
        for(Bookmark bk : getAllBookmarks()) {
             if(!categories.contains(bk.getCategory())) {
                    categories.add(bk.getCategory());
             }
        }
        return categories;
    }
    
}
