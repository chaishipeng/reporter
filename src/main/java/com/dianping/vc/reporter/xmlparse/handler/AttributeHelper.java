package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.Model;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class AttributeHelper {

    public static void fillAttr(Model model, Attributes attributes){
        BeanWrapper beanWrapper = new BeanWrapperImpl(model);
        for(int i = 0 ;i < attributes.getLength() ; i ++) {
            String key = attributes.getQName(i);
            String value = attributes.getValue(i);
            try {
                beanWrapper.setPropertyValue(key, value);
            } catch (Exception e) {

            }
        }
    }

}
