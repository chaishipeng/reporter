package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.Model;
import com.dianping.vc.reporter.model.TextMapModel;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/13.
 */
public class TextMapHandler extends AbstractModelHandler {
    public Model create() {
        return new TextMapModel();
    }

    public void fillAttr(Model model, Attributes attributes) {
        TextMapModel mapModel = (TextMapModel)model;
        AttributeHelper.fillAttr(model, attributes);
        Map<String, String> mappedRule = new HashMap<String, String>();
        for(int i = 0 ;i < attributes.getLength() ; i ++) {
            String key = attributes.getQName(i);
            String value = attributes.getValue(i);
            key = key.substring(1);
            mappedRule.put(key, value);
        }
        mapModel.setMappedRule(mappedRule);
    }
}
