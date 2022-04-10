package com.vu.foldersFind;


import java.io.File;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class SearchFile {
    private String pathMain;
    private static Map<Class, String> classMap = new HashMap<>();


    public static Map<Class, String> searchF(String namePatchFolder, Class clazzImpl) throws ClassNotFoundException {
        // System.out.println("namePath = " + namePath);

        File file = new File(namePatchFolder);

        for (File f : file.listFiles()) {

            if (f.isDirectory()) {
                //System.out.println(f.getName()); // "folder - " +

                //System.out.print("\t");
                searchF(namePatchFolder + "\\" + f.getName(), clazzImpl);
            } else if (f.isFile()) {
                //ystem.out.print("\t");
                //System.out.println("namePath = " + namePath);

                String namClass = f.getName().split("/.")[0];
                //System.out.println("namClass = " + namClass);
                String[] lastPath = namePatchFolder.split("\\\\java\\\\");

                String namePathFile = (lastPath[1] + "\\" + namClass).replaceAll("\\\\", ".");
                String b = namePathFile.substring(0, namePathFile.length() - 5);
                //System.out.println("b = " + b);

                Class clazz = Class.forName(b);
                Annotation[] annotations = clazz.getAnnotations();

                for (Annotation ann : annotations) {
                    if (ann.annotationType() == clazzImpl) {
                        System.out.println();
                        String n = ann.annotationType().getSimpleName();
                        System.out.println("Annotation: " + n);
                        System.out.println("Class: " + clazz.getSimpleName());
                        classMap.merge(clazz, n, (old, next) -> next);
                        System.out.println();

                    }

                }
            }
        }
        //classMap.forEach((k, v) -> System.out.println(k.getSimpleName() + " == " + v));
        return classMap;
    }

}