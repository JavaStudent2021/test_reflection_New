package com.vu.foldersFind;

import com.vu.dao.impl.BetDaoImpl;
import com.vu.lib.Dao;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchFile {
    private String pathMain;

    public static void searchF(String namePath) throws ClassNotFoundException {
        // System.out.println("namePath = " + namePath);

        File file = new File(namePath);

        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                //System.out.println(f.getName()); // "folder - " +

                System.out.print("\t");
                searchF(namePath + "/" + f.getName());
            } else if (f.isFile()) {
                System.out.print("\t");
                //System.out.println("str - "  + str);

                String namClass = f.getName().split("/.")[0];
                // System.out.println("namClass = " + namClass);
                String[] lastPath = namePath.split("/java/");


                String namePathFile = (lastPath[1] + "/" + namClass).replaceAll("/", ".");
                String b = namePathFile.substring(0, namePathFile.length() - 5);
                Class clazz = Class.forName(b);
                if (namClass.equals("BetDaoImpl.java")) {
                    Annotation[] annotations = clazz.getAnnotations();
                    System.out.println("annotations = " + annotations.length);
                    for (Annotation ann : annotations) {
                        System.out.println("Annotation: " + ann.annotationType().getSimpleName());
                    }
                }

                if (clazz.isAnnotationPresent(Dao.class)) {
                    System.out.println("ssss - " + clazz.getName());
                }
            }
        }
    }
}
