package View.Command;

import View.View;

public class AddHuman implements Command{
    private View view;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить запись";
    }

    @Override
    public void execute() {
        view.addHuman();
    }
}
