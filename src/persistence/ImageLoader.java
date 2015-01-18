package persistence;

import model.Bitmap;
import model.Image;
import model.RealImage;
import swing.SwingBitmap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {

    private final String path;

    ImageLoader(String source) {
        this.path = source;
    }

    public Image load() throws IOException {
        return new RealImage(loadBitmap());
    }

    private Bitmap loadBitmap() throws IOException {
        return new SwingBitmap(loadBufferedImage());
    }

    private BufferedImage loadBufferedImage() throws IOException {
        return ImageIO.read(new File(path));
    }
}
