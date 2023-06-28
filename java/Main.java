import presenter.Presenter;
import model.service.Service;
import view.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUi();
        Service service = new Service();
        new Presenter(view,service);
        view.test();
        view.start();
    }
}