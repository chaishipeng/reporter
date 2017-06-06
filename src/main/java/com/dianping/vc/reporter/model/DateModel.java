package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class DateModel extends ValueModel {

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    void fillValue(HSSFCell hssfCell, Object value, ModelContext context) {
        if (value == null){
            value = context.getCurrentData();
        }
        if (value instanceof Date){
            hssfCell.setCellValue((Date)value);
            return;
        }
        if (pattern == null) {
            throw new RuntimeException("Pattern is not null!");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date result = simpleDateFormat.parse(value + "");
            hssfCell.setCellValue(result);
        } catch (ParseException e) {

        }

    }
}
