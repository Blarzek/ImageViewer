package control;

import ui.ImageDialog;
import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {

    private final ImageDialog dialog;

    public NextImageCommand(ImageDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void execute() {
        this.dialog.setImage(this.dialog.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }

}