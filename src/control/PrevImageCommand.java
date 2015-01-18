package control;

import ui.ImageDialog;
import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {

    private final ImageDialog dialog;

    public PrevImageCommand(ImageDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void execute() {
        this.dialog.setImage(this.dialog.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
    
}