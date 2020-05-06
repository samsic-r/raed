package Reader;

import java.io.File;

public class ConsoleDescriptionWriter extends ScanWriter {

    @Override
    public void write(String dirbool, String file, String size) {
        System.out.println( dirbool + "  " + file + " Размер " + size );
    }
}
