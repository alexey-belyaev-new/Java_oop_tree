package model.fileHandler;

import java.io.*;

public class FileHandlerTree implements FileHandlerInterface{
    public FileHandlerTree() {
    }

    @Override
    public void saveFile(Serializable serializable, String str) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(str));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object loadFile( String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(str));
        return objectInputStream.readObject();
    }
}
