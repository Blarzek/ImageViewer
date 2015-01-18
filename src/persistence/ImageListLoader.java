package persistence;

import model.Image;
import model.ProxyImage;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class ImageListLoader {

    private final String path;

    public ImageListLoader(String path) {
        this.path = path;
    }

    public List<Image> load() {
        return linkImages(loadImages());
    }

    private List<Image> loadImages() {
        List<Image> list = new ArrayList<>();
        for (Object file : new File(path).list()) {
            list.add(new ProxyImage(new ImageLoader(path + "/" + file)));
        }
        return list;
    }

    private List<Image> linkImages(List<Image> images) {
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            image.setNext(images.get((i + 1) % images.size()));
            image.setPrev(images.get((i + images.size() - 1) % images.size()));
        }
        return images;
    }

}
