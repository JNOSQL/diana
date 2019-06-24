/*
 *  Copyright (c) 2019 Otávio Santana and others
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.jnosql.artemis.graph;

import org.jnosql.diana.SettingsPriority;
import org.omg.CORBA.PRIVATE_MEMBER;


/**
 * An utilitarian to {@link org.apache.tinkerpop.gremlin.structure.Transaction}
 */
enum GraphTransactionUtil {
    INSTANCE;

    private static final String TRANSACTION_KEY = "jakarta.nosql.transaction.automatic";


    /**
     * Check if the transaction is enable
     *
     * @return Check if the transaction is enable
     */
    public boolean isAutomatic() {
        return INSTANCE.isAutomaticImpl();
    }

    public boolean isAutomaticImpl() {
        return SettingsPriority.get(TRANSACTION_KEY)
                .map(Object::toString)
                .map(Boolean::valueOf)
                .orElse(false);
    }
}