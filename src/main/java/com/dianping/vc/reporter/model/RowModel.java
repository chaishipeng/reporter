package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ContextConstants;
import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class RowModel extends AbstractModel<HSSFSheet> {

    private String repeat;

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public void create(ModelContext context, HSSFSheet sheet){
        if (repeat == null) {
            HSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            super.childCreate(row, context);
            return;
        }
        List<Object> list = getList(context);
        int index = 0;
        for (Object obj : list) {
            context.setMeta(ContextConstants.LIST_INDEX, index);
            context.setMeta(ContextConstants.LIST_PHYSICAL_INDEX, index + 1);
            HSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            context.setCurrentData(obj);
            super.childCreate(row, context);
            index ++;
        }
    }

    @Override
    Object createInner(ModelContext context, HSSFSheet sheet) {
        return null;
    }

    private List<Object> getList(ModelContext context){
        Object data = context.getData(repeat);
        if (data.getClass().isArray()) {
            List<Object> list = new ArrayList<Object>();
            Object[] array = (Object[]) data;
            for (Object obj : array) {
                list.add(obj);
            }
            return list;
        }
        if (data instanceof List){
            return ((List)data);
        }
        throw new RuntimeException(repeat + " Is Not List or Array!");
    }
}
