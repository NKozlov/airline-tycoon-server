/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command.impl;

import org.yeti.console.command.AbstractCommand;
import org.yeti.console.command.CommandNames;
import org.yeti.console.command.RunCommand;

/**
 * Завершает работу сервера.
 *
 * @author Kozlov Nikita
 * @see RunCommand
 * @see AbstractCommand
 */
public class StopCommand extends AbstractCommand implements RunCommand {

    public StopCommand() {
        this.setCommandName(CommandNames.STOP.toString());
    }

    /**
     * Метод, который отвечает за запуск команды.
     */
    @Override
    public void apply() {
        this.doStopCommand();
    }
}
