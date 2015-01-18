package swing;

import control.ActionListenerFactory;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private JPanel options;
    private final ActionListenerFactory factory;
    private ImageViewerPanel imageViewerPanel;

    public ApplicationFrame(ActionListenerFactory factory) {
        this.factory = factory;
        addWidgets();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addWidgets() {
        add(createImagePanel());
        add(createOptionsPanel(), BorderLayout.SOUTH);
        options.add(createPrevButton(), BorderLayout.WEST);
        options.add(createNextButton(), BorderLayout.EAST);
    }

    private JPanel createImagePanel() {
        ImageViewerPanel panel = new ImageViewerPanel(getWidth(), getHeight()) {
            {
                getContentPane().addComponentListener(createComponentListener());
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
        this.imageViewerPanel = panel;
        return panel;
    }

    private JPanel createOptionsPanel() {
        options = new JPanel();
        return options;
    }

    private Component createNextButton() {
        JButton button = new JButton("Next >");
        button.addActionListener(factory.createActionListener("Next"));
        return button;
    }

    private Component createPrevButton() {
        JButton button = new JButton("< Previous");
        button.addActionListener(factory.createActionListener("Prev"));
        return button;
    }

    public ImageViewerPanel getImageViewerPanel() {
        return imageViewerPanel;
    }
}
