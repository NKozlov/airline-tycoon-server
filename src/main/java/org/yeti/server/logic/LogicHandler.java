/*
 * Copyright (c) 2013
 * Kozlov Nikita
 */
package org.yeti.server.logic;

/**
 * Интерфейс, предоставляющий API по обработке логики.
 *
 * @author Kozlov Nikita
 * @see NaturalSeqLogicHandler
 */
public interface LogicHandler<V> {

    V executeLogic();

    void doInit();
}
