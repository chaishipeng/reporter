package com.dianping.vc.reporter.xmlparse.handler;

import com.dianping.vc.reporter.model.Model;
import com.dianping.vc.reporter.model.RowModel;
import com.dianping.vc.reporter.xmlparse.ModelHandler;
import org.xml.sax.Attributes;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class RowHandler extends AbstractModelHandler {
    public Model create() {
        return new RowModel();
    }
}
