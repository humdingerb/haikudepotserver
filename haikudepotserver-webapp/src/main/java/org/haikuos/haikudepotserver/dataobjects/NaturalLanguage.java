/*
 * Copyright 2014, Andrew Lindesay
 * Distributed under the terms of the MIT License.
 */

package org.haikuos.haikudepotserver.dataobjects;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.Ordering;
import org.apache.cayenne.query.SelectQuery;
import org.apache.cayenne.query.SortOrder;
import org.haikuos.haikudepotserver.dataobjects.auto._NaturalLanguage;

import java.util.List;

public class NaturalLanguage extends _NaturalLanguage {

    public final static String CODE_ENGLISH = "en";
    public final static String CODE_GERMAN = "de";

    public static List<NaturalLanguage> getAll(ObjectContext context) {
        Preconditions.checkNotNull(context);
        SelectQuery query = new SelectQuery(NaturalLanguage.class);
        query.addOrdering(new Ordering(NAME_PROPERTY, SortOrder.ASCENDING));
        return (List<NaturalLanguage>) context.performQuery(query);
    }

    public static Optional<NaturalLanguage> getByCode(ObjectContext context, String code) {
        Preconditions.checkNotNull(context);
        Preconditions.checkState(!Strings.isNullOrEmpty(code));
        return Optional.fromNullable(Iterables.getOnlyElement(
                (List<NaturalLanguage>) context.performQuery(new SelectQuery(
                        NaturalLanguage.class,
                        ExpressionFactory.matchExp(MediaType.CODE_PROPERTY, code))),
                null));
    }

}