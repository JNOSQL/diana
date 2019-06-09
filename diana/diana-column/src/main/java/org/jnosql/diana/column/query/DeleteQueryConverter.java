/*
 *
 *  Copyright (c) 2017 Otávio Santana and others
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
 *
 */
package org.jnosql.diana.column.query;

import org.jnosql.diana.column.ColumnObserverParser;
import org.jnosql.query.DeleteQuery;

import java.util.function.BiFunction;

/**
 * A converter that converts {@link DeleteQuery} to {@link ColumnDeleteQueryParams}
 */
public interface DeleteQueryConverter extends BiFunction<DeleteQuery, ColumnObserverParser, ColumnDeleteQueryParams> {

    /**
     * A {@link DeleteQueryConverter} instance
     *
     * @return A {@link DeleteQueryConverter} instance
     */
    static DeleteQueryConverter get() {
        return DeleteQueryConverterFactory.INSTANCE;
    }
}