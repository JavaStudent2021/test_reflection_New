package com.vu.foldersFind;

import com.vu.dao.impl.BetDaoImpl;
import com.vu.lib.Dao;

import java.io.File;
import java.lang.annotation.Annotation;

public class SearchFile {
    private String pathMain;

    public SearchFile() {

    }

    public void searchF(String namePath) throws ClassNotFoundException {


        File file = new File(namePath);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                //System.out.println(f.getName()); // "folder - " +

                System.out.print("\t");
                searchF(namePath + "\\" + f.getName());
            } else if (f.isFile()) {
                System.out.print("\t");
                String str = f.getName();
                String[] q = str.split("\\.");
                //System.out.println("str - "  + str);
                String pathFile = namePath;
                String namClass = q[0];

                String[] lastPath = namePath.split("\\\\java\\\\");
                String namePathFile = (lastPath[1] + "\\" + namClass).replaceAll("\\\\", "\\.");

                //Class cazz = Class.forName(namePathFile);
                Class cazz = BetDaoImpl.class;

                //System.out.println("cazz.getName() - " + cazz.getAnnotations());


                if (q[0].equals("BetDaoImpl")){
                    System.out.println("BAY!!!!!!!!!");
                    Annotation[] annotations = cazz.getAnnotations();
                    System.out.println("annotations = " + annotations.length);
                    for (Annotation ann : annotations) {
                        System.out.println("Annotation: " + ann.annotationType().getSimpleName());
                    }
                }

                if (cazz.isAnnotationPresent(Dao.class)) {
                    System.out.println("ssss" + cazz.getName());
                }

            }
        }

    }

   /* public void searchF_test(String namePath) throws ClassNotFoundException {
        File file = new File(namePath);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {

                System.out.println(f.getName()); // "folder - " +
                String na = namePath + "\\" + f.getName();
                System.out.print("\t");
                //System.out.println("na = " + na);
                searchF(namePath + "\\" + f.getName());
            } else if (f.isFile()) {
                *//*System.out.print("\t");
                System.out.println(f.getName()); // "file - " +*//*
            }
        }

    }*/
}
