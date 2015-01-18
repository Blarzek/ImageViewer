package model;

public class RealImage extends Image {

    private final Bitmap bitmap;

    public RealImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public Image getNext() {
        return null;
    }

    @Override
    public Image getPrev() {
        return null;
    }

    @Override
    public void setNext(Image image) {
    }

    @Override
    public void setPrev(Image image) {
    }

}