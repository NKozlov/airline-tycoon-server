/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command.impl;

import org.yeti.console.command.AbstractCommand;
import org.yeti.console.command.CommandNames;
import org.yeti.console.command.RunCommand;

/**
 * Команда, которая осуществляет выход из консоли. Если сервер запущен, то вначале завершает его работу.
 *
 * @author Kozlov Nikita
 * @see RunCommand
 * @see AbstractCommand
 */
public class QuitCommand extends AbstractCommand implements RunCommand {

    public QuitCommand() {
        this.setCommandName(CommandNames.QUIT.toString());
    }

    /**
     * Метод, который отвечает за запуск команды.
     */
    @Override
    public void apply() {
        if (this.nettyServerAdmin.checkStatus()) {
            this.doStopCommand();
        }
        System.out.println("Bye bye, see u :)");
    }
}
