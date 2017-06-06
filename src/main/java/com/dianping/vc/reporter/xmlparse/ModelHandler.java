package com.dianping.vc.reporter.xmlparse;

import com.dianping.vc.reporter.model.Model;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public interface ModelHandler {

    Model create(Attributes attributes);

}
