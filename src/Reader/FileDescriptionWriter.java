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
    public void write(String dirbool, File file, Long size) throws IOException {
        PrintWriter pw = new PrintWriter( new FileWriter( reportFilePath +"/"+ reportFileName, true ) );
               pw.println( dirbool + "  " + file.getName() + " Размер " + size );
        pw.close();
    }
}
