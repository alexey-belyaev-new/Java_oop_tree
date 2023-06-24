package view.command;

import view.View;

import java.io.IOException;

public class SaveTree implements Command{
    View view;

    public SaveTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранение дерева";
    }

    @Override
    public void execute() throws IOException {
        view.saveTree();
    }
}
