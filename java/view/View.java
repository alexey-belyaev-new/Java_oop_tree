package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void print(String text);
    void start() throws IOException, ClassNotFoundException;
    void addHuman();
    void findHuman();
    void getInfoTree();
    void saveTree() throws IOException;
    void loadTree() throws IOException, ClassNotFoundException;
    void finish();
    void test();
}
