package Pruebas;

import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Cache is used to cache an image based on a set of arguments.
 */
public class ImageCache {
    // Maximum number of entries to cache
    private int maxCount;
    // The entries.
    final private LinkedList<SoftReference<Entry>> entries;

    public ImageCache(int maxCount) {
        this.maxCount = maxCount;
        entries = new LinkedList<SoftReference<Entry>>();
    }

    void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void flush() {
        entries.clear();
    }

    private Entry getEntry(Object key, GraphicsConfiguration config,
                           int w, int h, Object[] args) {
        Entry entry;
        Iterator<SoftReference<Entry>> iter = entries.listIterator();
        while (iter.hasNext()) {
            SoftReference<Entry> ref = iter.next();
            entry = ref.get();
            if (entry == null) {
                // SoftReference was invalidated, remove the entry
                iter.remove();
            }
            else if (entry.equals(config, w, h, args)) {
                // Put most recently used entries at the head
                iter.remove();
                entries.addFirst(ref);
                return entry;
            }
        }
        // Entry doesn't exist
        entry = new Entry(config, w, h, args);
        if (entries.size() >= maxCount) {
            entries.removeLast();
        }
        entries.addFirst(new SoftReference<Entry>(entry));
        return entry;
    }

    /**
     * Returns the cached Image, or null, for the specified arguments.
     */
    public Image getImage(Object key, GraphicsConfiguration config,
            int w, int h, Object[] args) {
        Entry entry = getEntry(key, config, w, h, args);
        return entry.getImage();
    }

    /**
     * Sets the cached image for the specified constraints.
     */
    public void setImage(Object key, GraphicsConfiguration config,
            int w, int h, Object[] args, Image image) {
        Entry entry = getEntry(key, config, w, h, args);
        entry.setImage(image);
    }


    /**
     * Caches set of arguments and Image.
     */
    private static class Entry {
        final private GraphicsConfiguration config;
        final private int w;
        final private int h;
        final private Object[] args;
        private Image image;

        Entry(GraphicsConfiguration config, int w, int h, Object[] args) {
            this.config = config;
            this.args = args;
            this.w = w;
            this.h = h;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }

        public String toString() {
            String value = super.toString() +
                    "[ graphicsConfig=" + config +
                    ", image=" + image +
                    ", w=" + w + ", h=" + h;
            if (args != null) {
                for (int counter = 0; counter < args.length; counter++) {
                    value += ", " + args[counter];
                }
            }
            value += "]";
            return value;
        }

        public boolean equals(GraphicsConfiguration config,
                 int w, int h, Object[] args) {
            if (this.w == w && this.h == h &&
                    ((this.config != null && this.config.equals(config)) ||
                    (this.config == null && config == null))) {
                if (this.args == null && args == null) {
                     return true;
                 }
                 if (this.args != null && args != null &&
                         this.args.length == args.length) {
                     for (int counter = args.length - 1; counter >= 0;
                     counter--) {
                         Object a1 = this.args[counter];
                         Object a2 = args[counter];
                         if ((a1 == null && a2 != null) ||
                                 (a1 != null && !a1.equals(a2))) {
                             return false;
                         }
                     }
                     return true;
                 }
             }
             return false;
         }
     }
 }