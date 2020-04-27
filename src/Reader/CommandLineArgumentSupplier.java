package Reader;

import java.io.File;

public class CommandLineArgumentSupplier implements ArgumentSupplier {

    private String[] argumentsArray;

    public CommandLineArgumentSupplier(String[] argumentsArray) {
        this.argumentsArray = argumentsArray;
    }


    @Override
    public Arguments processArguments() throws ArgumentsException {

        if (argumentsArray != null && argumentsArray.length == 3) {
            String directoryForScan = checkAndGetDirectoryForScan( argumentsArray[0] );
            String reportPath = checkAndGetReportPath( argumentsArray[1] );
            String reportFileName = checkAndGetReportFileName( argumentsArray[2] );
            String extenstionFilter = "";
            System.out.println( "Не введен аргумент для поиска файлов с заданным расширением\nСписок всех папок и файлов в каталоге:" );
            return new Arguments( directoryForScan, reportPath, reportFileName, extenstionFilter );

        } else if (argumentsArray != null && argumentsArray.length == 4) {
            String directoryForScan = checkAndGetDirectoryForScan( argumentsArray[0] );
            String reportPath = checkAndGetReportPath( argumentsArray[1] );
            String reportFileName = checkAndGetReportFileName( argumentsArray[2] );
            String extenstionFilter = argumentsArray[3];
            System.out.println( "Список файлов c расширением (" + argumentsArray[3] + ")" );
            return new Arguments( directoryForScan, reportPath, reportFileName, extenstionFilter );

        } else if (argumentsArray != null && argumentsArray.length >= 5) {
            throw new ArgumentsException( "Превышено число введенных аргументов. Максимальное число аргументов (4)" );
        }
        throw new ArgumentsException( "Неверное число введенных аргументов. Минимальное число аргументов (3)" );
    }

    public String checkAndGetDirectoryForScan(String directory) throws ArgumentsException {
        File file = new File( directory );
        if (!file.exists()) throw new ArgumentsException( "Директория для сканирования не найдена!!!\n" +
                "Выберите диск для сканирования из предложенных выше или введите путь до требуемой директории, например (D:/Название папки)" );
        else return directory;
    }

    public String checkAndGetReportPath(String reportPath) throws ArgumentsException {
        File file = new File( reportPath );
        if (!file.exists())
            throw new ArgumentsException( "Директория для сохранения файла не найдена или введена не верно!!!\n" +
                    "Примеры ввода (D:/ или D:/Название папки)" );
        else return reportPath;
    }

    public String checkAndGetReportFileName(String reportFileName) throws ArgumentsException {
        char[] chars = {'\\', '/', ':', '*', '?', '"', '<', '>', '|'};
        for (char c : chars) {
            if (reportFileName.indexOf( c ) != -1)
                throw new ArgumentsException( "Введено недопустимое имя файла.\n" +
                        "Имя файла не должно содержать символов (\\, /, |, :, *, ?, '', <, >)" );
            else continue;
        }
        return reportFileName;
    }

}
