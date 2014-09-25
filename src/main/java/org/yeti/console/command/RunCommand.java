/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command;

/**
 * Интерфейс для команд консоли. Содержит метод {@link org.yeti.console.command.RunCommand#apply()}, который запускает выполнение команд.
 *
 * @author Kozlov Nikita
 * @see org.yeti.console.command.impl.HelpCommand
 * @see org.yeti.console.command.impl.QuitCommand
 * @see org.yeti.console.command.impl.ResetCommand
 * @see org.yeti.console.command.impl.RestartCommand
 * @see org.yeti.console.command.impl.StartCommand
 * @see org.yeti.console.command.impl.StopCommand
 * @see org.yeti.console.command.impl.WelcomeCommand
 */
public interface RunCommand {

    /**
     * Метод, который отвечает за запуск команды.
     */
    void apply();

    /**
     * Возвращает имя команды.
     *
     * @return String - имя команды.
     */
    String getCommandName();
}
