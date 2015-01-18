package swing;

import model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import ui.ImageDialog;

public class ImageViewerPanel extends JPanel implements ImageDialog {

    private Image image;
    private final int offset;

    public void show(Image image) {
        this.image = image;
        repaint();
    }

    public ImageViewerPanel() {
        this.offset = 0;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    private BufferedImage getBitmap() {
        if (image.getBitmap() instanceof SwingBitmap) {
            return getBufferedImage((SwingBitmap) image.getBitmap());
        }
        return null;
    }

    private BufferedImage getBufferedImage(SwingBitmap swingBitmap) {
        return swingBitmap.getBufferedImage();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        super.paint(graphics);
        graphics.drawImage(getBitmap(), offset, 0, null);
        if (offset == 0) {
            return;
        }
        if (offset < 0) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getNext().getBitmap()), image.getBitmap().getWidth() + offset, 0, null);
        }
        if (offset > 0) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getPrev().getBitmap()), offset - image.getBitmap().getWidth(), 0, null);
        }
    }
}
