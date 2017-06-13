package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.Model;
import com.dianping.vc.reporter.xmlparse.ModelHandler;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/13.
 */
public abstract class AbstractModelHandler implements ModelHandler {

    public void fillAttr(Model model, Attributes attributes) {
        AttributeHelper.fillAttr(model, attributes);
    }
}
