package view.command;

import view.View;

import java.io.IOException;

public class SortByName implements Command{
    View view;

    public SortByName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Отсортировать записи по имени";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.sortByName();
    }
}
