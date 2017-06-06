package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class StyleModel extends AbstractModel<HSSFCell> {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    Object createInner(ModelContext context, HSSFCell hssfCell) {
        HSSFCellStyle style = context.getBook().createCellStyle();
        style.setFillBackgroundColor(ColorHelper.getColor(color));
        hssfCell.setCellStyle(style);
        return style;
    }
}
