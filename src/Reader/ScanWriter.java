package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ScanWriter {

    public abstract void write(String d, String n, String s) throws IOException;
}