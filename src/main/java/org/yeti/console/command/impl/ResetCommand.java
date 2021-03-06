/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yeti.console.command.AbstractCommand;
import org.yeti.console.command.CommandNames;
import org.yeti.console.command.RunCommand;

import java.io.IOException;

/**
 * Команда, которая сбрасывает последовательность в 1.
 *
 * @author Kozlov Nikita
 * @see RunCommand
 * @see AbstractCommand
 */
public class ResetCommand extends AbstractCommand implements RunCommand {

    private static final Logger logger = LoggerFactory.getLogger(ResetCommand.class);

    public ResetCommand() {
        this.setCommandName(CommandNames.RESET.toString());
    }

    /**
     * Метод, который отвечает за запуск команды.
     */
    @Override
    public void apply() {
        if (this.nettyServerAdmin.checkStatus()) {
            System.out.println("Please stop the server before using the reset command.");
        } else {
            try {
                fileExecutor.writeToFile("0");
            } catch (IOException e) {
                logger.error("{}", e.getMessage());
            }
            System.out.println("The sequence is reset to 1.");
        }
    }
}
