/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.console.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.yeti.server.admin.NettyServerAdminInterface;
import org.yeti.server.admin.exceptions.NettyServerAlreadyStartedException;
import org.yeti.server.admin.exceptions.NettyServerAlreadyStoppedException;
import org.yeti.server.logic.file.FileExecutor;

/**
 * Содержит методы, которые являются общими для большинства команд консоли.
 *
 * @author Kozlov Nikita
 */
abstract public class AbstractCommand implements RunCommand {

    @Autowired
    @Qualifier(value = "nettyServerAdmin")
    protected NettyServerAdminInterface nettyServerAdmin;

    @Autowired
    protected FileExecutor fileExecutor;

    protected String commandName;

    /**
     * Возвращает имя команды.
     *
     * @return String - имя команды.
     */
    @Override
    public String getCommandName() {
        return commandName;
    }

    protected void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    protected void doStopCommand() {
        try {
            System.out.println("Server begins its graceful shutdown.");
            this.nettyServerAdmin.stop();
            System.out.println("Server was stopped successfully.");
        } catch (NettyServerAlreadyStoppedException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doStartCommand() {
        try {
            System.out.println("The server is started. Port: 80");
            this.nettyServerAdmin.start();
            System.out.println("The server was started successfully.");
        } catch (NettyServerAlreadyStartedException e) {
            System.out.println(e.getMessage());
        }
    }
}
