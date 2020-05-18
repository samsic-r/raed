package Reader;

import java.io.File;
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
        File folder = new File( arguments.getDirectoryForScan() );
        scanDirectoryRecursive( folder );
    }

    public long getFolderSize(File filelsit) throws NullPointerException {

        long length = 0;
        try {
            for (File file : filelsit.listFiles()) {
                if (file.isFile())
                    length += file.length();
                else
                    length += getFolderSize( file );
            }
            return length;
        } catch (NullPointerException ignored) {

        }
        return length;
    }

    private void scanDirectoryRecursive(File folder) throws IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory() && file.listFiles() == null) {
                outWriter( file, file.length() );
            } else if (file.isFile() && file.getName().endsWith( arguments.getExtenstionFilter() )) {
                outWriter( file, file.length() );
            } else if (file.isDirectory() && arguments.getExtenstionFilter().equals( "" )) {
                outWriter( file, getFolderSize( file ) );
                scanDirectoryRecursive( file );
            } else if (file.isDirectory()) {
                scanDirectoryRecursive( file );
            }
        }
    }

    public void outWriter(File name, Long size) throws IOException {
        for (ScanWriter writer : writers) {
            writer.write( name, size );

        }
    }
}




