/*
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
 */
package org.eclipse.jnosql.mapping.keyvalue;

import jakarta.nosql.keyvalue.BucketManager;
import jakarta.nosql.mapping.keyvalue.KeyValueEntityConverter;
import jakarta.nosql.mapping.keyvalue.KeyValueWorkflow;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.time.Duration;
import java.util.Optional;

class DefaultKeyValueTemplate extends AbstractKeyValueTemplate {

    private KeyValueEntityConverter converter;

    private Instance<BucketManager> manager;

    private KeyValueWorkflow flow;

    @Inject
    DefaultKeyValueTemplate(KeyValueEntityConverter converter, Instance<BucketManager> manager, KeyValueWorkflow flow) {
        this.converter = converter;
        this.manager = manager;
        this.flow = flow;
    }

    DefaultKeyValueTemplate() {
    }

    @Override
    protected KeyValueEntityConverter getConverter() {
        return converter;
    }

    @Override
    protected BucketManager getManager() {
        return manager.get();
    }

    @Override
    protected KeyValueWorkflow getFlow() {
        return flow;
    }

    @Override
    public <T> T insert(T entity) {
        return put(entity);
    }

    @Override
    public <T> T insert(T entity, Duration ttl) {
        return put(entity, ttl);
    }


    @Override
    public <T, K> Optional<T> find(Class<T> entityClass, K id) {
        return Optional.empty();
    }

    @Override
    public <T, K> void delete(Class<T> entityClass, K id) {

    }
}
