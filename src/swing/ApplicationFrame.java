package swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private Image image;

    public ApplicationFrame() {
        image = readImage();
        addWidgets();
        setVisible(true);
        setSize(500, 500);
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addWidgets() {
        add(createImagePanel());
    }

    private JPanel createImagePanel() {
        return new JPanel() {
            {
                getContentPane().addComponentListener(createComponentListener());
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }

            private ComponentListener createComponentListener() {
                return new ComponentListener() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        revalidate();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                };
            }

        };
    }

    private Image readImage() {
        try {
            return ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"));
        } catch (IOException ex) {
            return null;
        }
    }

}
