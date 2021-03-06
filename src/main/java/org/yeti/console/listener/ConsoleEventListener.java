/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.yeti.console.ConsoleEventHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Листенер консоли. "Слушает" клавиатуру пользователя и, после нажатия Enter, считывает консоль и отдает обработчику {@link ConsoleEventHandler}. <br/>
 * <p/>
 * Singleton. Инициализируется в IoC-контейнере. Поток создается и запускается из {@link org.yeti.Bootstrap}
 *
 * @author Kozlov Nikita
 * @see ConsoleEventHandler
 * @see org.yeti.Bootstrap
 */
public class ConsoleEventListener implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleEventListener.class);

    @Autowired
    ConsoleEventHandler consoleEventHandler;

    @Override
    public void run() {

        String line = "";
        boolean exitFlag = false;
        consoleEventHandler.printWelcomeMessage();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // слушаем, пока exitFlag = false.
            while (!exitFlag) {

                System.out.print(">");
                line = in.readLine();
                exitFlag = consoleEventHandler.processEvent(line);
            }
        } catch (IOException e) {
            logger.error("[{}]: {}", Thread.currentThread().getName(), e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
