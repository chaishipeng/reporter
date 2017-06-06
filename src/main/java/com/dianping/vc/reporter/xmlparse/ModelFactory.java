package com.dianping.vc.reporter.xmlparse;

import com.dianping.vc.reporter.model.Model;
import com.dianping.vc.reporter.xmlparse.handler.AttributeHelper;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ModelFactory {

    private Map<String, ModelHandler> handlerMap = new HashMap();

    public Model createModel(String modelName, Attributes attributes) {
        ModelHandler handler = handlerMap.get(modelName);
        Model model = handler.create(attributes);
        AttributeHelper.fillAttr(model, attributes);
        return model;
    }

    public void registerHandler(String name, ModelHandler handler) {
        handlerMap.put(name, handler);
    }

}
