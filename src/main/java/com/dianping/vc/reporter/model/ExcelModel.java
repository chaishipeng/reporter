package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ExcelModel extends AbstractModel{

    @Override
    Object createInner(ModelContext context, Object o) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        context.setBook(hssfWorkbook);
        return hssfWorkbook;
    }
}
