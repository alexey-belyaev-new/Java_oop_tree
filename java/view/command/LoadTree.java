package view.command;

import view.View;

import java.io.IOException;

public class LoadTree implements Command {
    View view;

    public LoadTree(View view) {
        this.view = view;
    }


    @Override
    public String getDescription() {
        return "Загрузка дерева из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.loadTree();
    }
}
