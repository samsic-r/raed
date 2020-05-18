package Reader;


import java.io.*;

public class FileDescriptionWriter extends ScanWriter {

    private String reportFilePath;
    private String reportFileName;

    public FileDescriptionWriter(String reportFilePath, String reportFileName) {
        this.reportFilePath = reportFilePath;
        this.reportFileName = reportFileName;
    }


    @Override
    public void write(File file, Long size) throws IOException {
        PrintWriter pw = new PrintWriter( new FileWriter( reportFileName, true ) );
        if (file.isFile()) pw.println( super.getInfoFile( file, size ) );
        else {
            pw.println( "---------------------------" );
            pw.println( super.getInfoDirectory( file, size ) );
            pw.println( "---------------------------" );
        }
        pw.close();
    }
}
