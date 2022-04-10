
import com.vu.controller.ConsoleHandler;
import com.vu.foldersFind.SearchFile;
import com.vu.lib.Dao;
import com.vu.lib.Impl;
import com.vu.lib.Injector;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handle();

       // SearchFile.searchF("C:\\New folder\\Dady\\java_\\java-cours\\advanced_course\\src\\main\\java\\com\\vu"); //"/home/viktor/java_/itvdn/other/test_reflection_New/src/main/java/com/vu"); //C:\DiskD\09-11-2012_2\для Виктора\Для планшету\Java\other_itvdn\test_reflection_New\src\main\java\com\vu
    }
}
