/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.server.admin;

/**
 * Интерфейс для {@link org.yeti.server.NettyServer}, расширяет возможности {@link ServerAdminInterface}
 *
 * @author Kozlov Nikita
 * @see ServerAdminInterface
 */
public interface NettyServerAdminInterface extends ServerAdminInterface {

    /**
     * Проверяет статус сервера.<br/>
     * <u>true</u> - запущен, <u>false</u> - не запущен.
     */
    boolean checkStatus();
}
