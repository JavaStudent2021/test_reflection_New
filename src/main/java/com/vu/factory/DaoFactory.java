package com.vu.factory;

public class DaoFactory {
    private static Object newClazz;

    public static Object getObject(String clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (newClazz == null) {
            System.out.println("clazz = " + clazz);
            Class cl = Class.forName(clazz);
            System.out.println("cl = " + cl.getClass());
            newClazz = cl.newInstance();
            return newClazz;
        } else {
            return null;
        }

    }

}