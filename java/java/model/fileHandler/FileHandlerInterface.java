package model.fileHandler;

import java.io.IOException;
import java.io.Serializable;

public interface FileHandlerInterface {
    void saveFile(Serializable serializable, String str) throws IOException;

    Object loadFile( String str) throws IOException, ClassNotFoundException;
}
