package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;


public class FileScanner {
    private final Arguments arguments;
    private final Collection<ScanWriter> writers;

    public FileScanner(Arguments arguments, Collection<ScanWriter> writers) {
        this.arguments = arguments;
        this.writers = writers;
    }

    public void execute() throws IOException {
        File files = new File( arguments.GetDirectoryForScan() );
        ext( files );
    }
    // изерение размера папки со всеми вложениями
    public long getFolderSize(File filelsit) {
        long length = 0;
        for (File file : filelsit.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += getFolderSize( file );
        }
        return length;

    }
    //метод поиска по расширению
    private void ext(File filelsit) throws IOException {

        for (File file : filelsit.listFiles()) {
            if (file.isDirectory() && file.listFiles() == null) {
                for (ScanWriter scan : writers) {
                    scan.write( "Директория", file, file.length() );
                }
            } else if (file.isFile() && file.getName().endsWith( arguments.GetExtenstionFilter() )) {
                for (ScanWriter scan : writers) {
                    scan.write( "Файл", file, file.length() );
                }
            } else if (file.isDirectory() && arguments.GetExtenstionFilter() == "") {

                for (ScanWriter scan : writers) {
                    scan.write( "Директория", file, getFolderSize( file ) );
                }
                ext( file );
            } else if (file.isDirectory()) {
                ext( file );
            }
        }
    }
}




