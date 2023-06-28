package view.command;

import view.View;

import java.io.IOException;

public class SortByAge implements Command{
    View view;

    public SortByAge(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Отсортировать записи по возрасту";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.sortByAge();
    }
}
