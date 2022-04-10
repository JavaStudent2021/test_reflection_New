package com.vu.controller;

import com.vu.dao.BetDao;
import com.vu.dao.HumanDao;
import com.vu.dao.impl.BetDaoImpl;
import com.vu.lib.Inject;
import com.vu.lib.Injector;
import com.vu.model.Bet;
import com.vu.model.Human;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;


    private HumanDao humanDao;

    public void handle() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Scanner scanner = new Scanner(System.in);
        int value;
        int risk;
        betDao.add(new Bet(4,2.4));
        //humanDao.addHuman(new Human());
        //betDao.add(new Bet());
    }
}
