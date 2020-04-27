package Reader;

import java.io.File;

public class ConsoleDescriptionWriter extends ScanWriter {

    @Override
    public void write(String dirbool, File file, Long size) {
        System.out.println( dirbool + "  " + file.getName() + " Размер " + size );
    }
}
