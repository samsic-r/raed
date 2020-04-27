package Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ScanApplication {

    public static void main(String[] args) throws ArgumentsException, IOException {

        String[] arg = new String[]{"d:\\ff 2", "d:/java", "12.txt" , ""};  /* для проверки не из консоли
         (где искать, куда сохранить отчет, Имя отчета, фильтр расширения) */

        ArgumentSupplier argumentSupplier = new CommandLineArgumentSupplier( arg );
        Arguments arguments = argumentSupplier.processArguments();
        Collection<ScanWriter> writers = List.of( new FileDescriptionWriter( arguments.GetReportPath(), arguments.GetReportFileName() ),
                new ConsoleDescriptionWriter() );
        FileScanner scanner = new FileScanner( arguments, writers );
        scanner.execute();
    }
}