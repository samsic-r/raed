package Reader;

public class Arguments {
    private String directoryForScan;
    private String reportPath;
    private String reportFileName;
    private String extenstionFilter;

    public Arguments(String directoryForScan, String reportPath, String reportFileName, String extenstionFilter) {
        this.directoryForScan = directoryForScan;
        this.reportPath = reportPath;
        this.reportFileName = reportFileName;
        this.extenstionFilter = extenstionFilter;
    }

    public String getDirectoryForScan() {
        return directoryForScan;
    }

    public String getReportPath() {
        return reportPath;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public String getExtenstionFilter() {
        return extenstionFilter;
    }


}