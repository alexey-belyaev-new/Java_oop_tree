package view;

import view.command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(view));
        commandList.add(new FindHuman(view));
        commandList.add(new GetInfoTree(view));
        commandList.add(new SaveTree(view));
        commandList.add(new Finish(view));

    }
    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int numCommand) throws IOException {
        commandList.get(numCommand -1 ).execute();
    }

    public int size() {
        return commandList.size();
    }
}
