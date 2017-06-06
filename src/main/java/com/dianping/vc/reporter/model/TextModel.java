package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class TextModel extends ValueModel {
    @Override
    void fillValue(HSSFCell hssfCell, Object value, ModelContext context) {
        if (value == null){
            value = context.getCurrentData();
        }
        hssfCell.setCellValue(value + "");
    }
}
