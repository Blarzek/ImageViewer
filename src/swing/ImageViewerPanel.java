package swing;

import model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import ui.ImageDialog;

public class ImageViewerPanel extends JPanel implements ImageDialog {

    private Image image;

    public void show(Image image) {
        this.image = image;
        repaint();
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
        graphics.drawImage(getBitmap(), 0, 0, getWidth(), getHeight(), null);
    }
}