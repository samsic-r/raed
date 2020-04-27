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

    public String GetDirectoryForScan() {
        return directoryForScan;
    }

    public String GetReportPath() {
        return reportPath;
    }

    public String GetReportFileName() {
        return reportFileName;
    }

    public String GetExtenstionFilter() {
        return extenstionFilter;
    }


}