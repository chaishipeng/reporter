package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.ExcelModel;
import com.dianping.vc.reporter.xmlparse.ModelHandler;
import com.dianping.vc.reporter.model.Model;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ExcelHandler implements ModelHandler {
    public Model create(Attributes attributes) {
        return new ExcelModel();
    }
}
