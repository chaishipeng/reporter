package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public abstract class ValueModel extends AbstractModel<HSSFCell> {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    Object createInner(ModelContext context, HSSFCell hssfCell) {
        Object cellValue = getCellValue(context);
        fillValue(hssfCell, cellValue, context);
        return hssfCell;
    }

    abstract void fillValue(HSSFCell hssfCell, Object value, ModelContext context);

    private Object getCellValue(ModelContext context){
        if (value == null){
            return null;
        }
        if (value.startsWith("{") && value.endsWith("}")) {
            return context.getData(value.substring(1, value.length() - 1));
        }
        if (value.startsWith("$_")){
            return context.getMeta(value);
        }
        return value;
    }
}
