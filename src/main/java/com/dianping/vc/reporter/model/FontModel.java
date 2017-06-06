package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class FontModel extends AbstractModel<HSSFCellStyle> {

    private String color;

    private short size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    @Override
    Object createInner(ModelContext context, HSSFCellStyle hssfCellStyle) {
        HSSFFont font = context.getBook().createFont();
        font.setColor(ColorHelper.getColor(color));
        if (size > 0) {
            font.setFontHeightInPoints(size);
        }
        hssfCellStyle.setFont(font);
        return font;
    }
}
