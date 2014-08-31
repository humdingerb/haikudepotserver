/*
 * Copyright 2014, Andrew Lindesay
 * Distributed under the terms of the MIT License.
 */

package org.haikuos.haikudepotserver.multipage.markup;

import com.google.common.collect.Lists;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.haikuos.haikudepotserver.dataobjects.NaturalLanguage;
import org.haikuos.haikudepotserver.multipage.MultipageConstants;
import org.haikuos.haikudepotserver.multipage.MultipageHelper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.tags.RequestContextAwareTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>This tag renders a list of languages allowing the user to choose one of those languages.</p>
 */

public class NaturalLanguageChooserTag extends RequestContextAwareTag {

    private ObjectContext getObjectContext() {
        return getRequestContext().getWebApplicationContext().getBean(ServerRuntime.class).getContext();
    }

    @Override
    protected int doStartTagInternal() throws Exception {

        ObjectContext context = getObjectContext();
        TagWriter tagWriter = new TagWriter(pageContext.getOut());
        List<NaturalLanguage> naturalLanguages = Lists.newArrayList(NaturalLanguage.getAll(context));
        NaturalLanguage currentNaturalLanguage = MultipageHelper.deriveNaturalLanguage(
                context,
                (HttpServletRequest) pageContext.getRequest());

        Collections.sort(naturalLanguages, new Comparator<NaturalLanguage>() {
                    @Override
                    public int compare(NaturalLanguage o1, NaturalLanguage o2) {
                        return o1.getCode().compareTo(o2.getCode());
                    }
                }
        );

        tagWriter.startTag("span");
        tagWriter.writeAttribute("class","multipage-natural-language-chooser");

        for(int i=0;i<naturalLanguages.size();i++) {

            NaturalLanguage naturalLanguage = naturalLanguages.get(i);

            if(0 != i) {
                tagWriter.appendValue(" ");
            }

            if(currentNaturalLanguage != naturalLanguage) {

                ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
                builder.replaceQueryParam(MultipageConstants.KEY_NATURALLANGUAGECODE, naturalLanguage.getCode());

                tagWriter.startTag("a");
                tagWriter.writeAttribute("href",builder.build().toString());
                tagWriter.appendValue(naturalLanguage.getCode());
                tagWriter.endTag(); // a

            }
            else {
                tagWriter.startTag("strong");
                tagWriter.appendValue(naturalLanguage.getCode());
                tagWriter.endTag(); // strong
            }

        }

        tagWriter.endTag(); // span

        return SKIP_BODY;
    }

}