package model;

import persistence.ImageLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyImage extends Image {

    private final ImageLoader imageLoader;
    private Image next;
    private Image prev;
    private Image realImage;

    public ProxyImage(ImageLoader loader) {
        this.imageLoader = loader;
    }

    @Override
    public Bitmap getBitmap() {
        try {
            checkLoaded();
        } catch (IOException ex) {
            Logger.getLogger(ProxyImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realImage.getBitmap();
    }

    private void checkLoaded() throws IOException {
        if (realImage != null) {
            return;
        }
        realImage = imageLoader.load();
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }

}
