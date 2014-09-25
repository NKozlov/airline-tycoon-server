/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.server;

import org.yeti.server.logic.file.FileReadQueueHandler;
import org.yeti.server.logic.session.HttpSessionReadQueueHandler;

/**
 * Хранит в себе статические ссылки на основные ресурсы, которые использует для своей работы сервера. <br/>
 * <ul>
 * <p/>
 * <li>{@link ServerResources#fileReadQueueHandler} - очередь и ее обработчик задач на запись в файл.</li>
 * <li>{@link ServerResources#httpSessionReadQueueHandler} - очередь и ее обработчик задач на обработку сессий подключений клиентов.</li>
 * </ul>
 * Используется для доступа к ресурсам из любой части кода, посредством статических методов:
 * {@link org.yeti.server.ServerResources#getFileReadQueueHandler()} и
 * {@link org.yeti.server.ServerResources#getHttpSessionReadQueueHandler()}. <br/>
 * Инициализируется в IoC-контейнере, а значения ссылок инициализируется в соответствующих контроллерах:
 * {@link org.yeti.server.admin.FileReadQueueAdmin}, {@link org.yeti.server.admin.SessionReadQueueAdmin}
 *
 * @author Kozlov Nikita
 * @see org.yeti.server.admin.FileReadQueueAdmin
 * @see org.yeti.server.admin.SessionReadQueueAdmin
 */
public class ServerResources {

    private static HttpSessionReadQueueHandler httpSessionReadQueueHandler;
    private static FileReadQueueHandler fileReadQueueHandler;

    public void setHttpSessionReadQueueHandler(HttpSessionReadQueueHandler httpSessionReadQueueHandler) {
        ServerResources.httpSessionReadQueueHandler = httpSessionReadQueueHandler;
    }

    public static HttpSessionReadQueueHandler getHttpSessionReadQueueHandler() {
        return httpSessionReadQueueHandler;
    }

    public static FileReadQueueHandler getFileReadQueueHandler() {
        return fileReadQueueHandler;
    }

    public void setFileReadQueueHandler(FileReadQueueHandler fileReadQueueHandler) {
        ServerResources.fileReadQueueHandler = fileReadQueueHandler;
    }
}
