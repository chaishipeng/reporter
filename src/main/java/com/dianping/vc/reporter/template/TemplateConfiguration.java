package com.dianping.vc.reporter.template;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chaishipeng on 2017/6/7.
 */
public interface TemplateConfiguration {

    Template loadTemplate(InputStream is) throws IOException;

    Template loadTemplate(String name) throws IOException;

    void setBasePath(String path);
    
}
