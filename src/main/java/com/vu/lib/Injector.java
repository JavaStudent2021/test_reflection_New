package com.vu.lib;

import com.vu.dao.BetDao;
import com.vu.dao.impl.BetDaoImpl;
import com.vu.factory.DaoFactory;
import com.vu.foldersFind.SearchFile;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Injector {
    private static String namePatchFolder = "C:\\New folder\\Dady\\java_\\java-cours\\advanced_course\\src\\main\\java\\com\\vu";
    private static Map<Class, String> classArrayList = new HashMap<>();


    public static Object getInstance(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        //System.out.println("instance = " + instance.getClass().getName());

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //System.out.println(field.getName());
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                System.out.println("\nfield.getName(); - " + field.getName());
                //System.out.println("field - " + field.getType().getSimpleName().toUpperCase().startsWith(field.getName().toUpperCase(), 0));
                //List<Class> aClassDao = reflectionsScan(field.getName(), Dao.class);
                Class aClassDao = reflectionsScan(field.getName(), Dao.class);

                if (aClassDao != null) {
                    System.out.println("aClassDao = " + aClassDao.getSimpleName());
                    field.set(instance, DaoFactory.getObject(aClassDao.getName()));
                }

            }
        }
        return instance;
    }

    private static Class reflectionsScan(String type, Class clazzImpl) throws ClassNotFoundException {
        Map<Class, String> listClass = SearchFile.searchF(namePatchFolder, clazzImpl);
        //ArrayList<Class> arrayList = new ArrayList<>();
        Class nameClass;
        String nameAnnot;
        //listClass.forEach((k,v)-> System.out.println(k+" == "+v));
        for (Map.Entry<Class, String> clazz : listClass.entrySet()) {
            nameClass = clazz.getKey();
            nameAnnot = clazz.getValue();

            if (nameAnnot.equals(clazzImpl.getSimpleName())) {
               /* System.out.println("nameClass = " + nameClass.getSimpleName());
                System.out.println("nameAnnot = " + nameAnnot);
                System.out.println("type = " + type);*/

                // arrayList.add(nameClass);
               // System.out.println(type.toUpperCase() +" // "+ nameClass.getSimpleName().toUpperCase());

                if (nameClass.getSimpleName().toUpperCase().startsWith(type.toUpperCase(),0)) {
                   // System.out.println("nameClass.getSimpleName() = " + nameClass.getSimpleName());
                    return nameClass;
                }

            }
        }
        return null;
    }

}
