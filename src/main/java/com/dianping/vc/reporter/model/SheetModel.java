package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class SheetModel extends AbstractModel {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    Object createInner(ModelContext context, Object o) {
        HSSFSheet sheet = context.getBook().createSheet(name);
        return sheet;
    }
}
