package view.command;

import view.View;

public class GetInfoTree implements Command{
    private View view;

    public GetInfoTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать всё дерево";
    }

    @Override
    public void execute() {
        view.getInfoTree();
    }
}
