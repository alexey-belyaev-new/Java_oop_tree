package View;

import Presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void print(String text);
    void start();
    void addHuman();
    void findHuman();
    void getInfoTree();
    void finish();
}
