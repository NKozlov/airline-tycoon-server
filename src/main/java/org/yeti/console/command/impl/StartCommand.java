/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command.impl;

import org.yeti.console.command.AbstractCommand;
import org.yeti.console.command.RunCommand;

/**
 * Запускает сервер.
 *
 * @author Kozlov Nikita
 * @see RunCommand
 * @see AbstractCommand
 */
public class StartCommand extends AbstractCommand implements RunCommand {

    public StartCommand() {
        this.setCommandName("start");
    }

    /**
     * Метод, который отвечает за запуск команды.
     */
    @Override
    public void apply() {
        this.doStartCommand();
    }
}
