package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.Model;
import com.dianping.vc.reporter.model.SheetModel;
import com.dianping.vc.reporter.xmlparse.ModelHandler;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class SheetHandler extends AbstractModelHandler{
    public Model create() {
        Model sheetModel = new SheetModel();
        return sheetModel;
    }
}
