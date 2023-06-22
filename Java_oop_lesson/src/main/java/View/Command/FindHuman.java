package View.Command;

import View.View;

public class FindHuman implements Command{
    private View view;

    public FindHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Найти человека по имени";
    }

    @Override
    public void execute() {
        view.findHuman();
    }
}
