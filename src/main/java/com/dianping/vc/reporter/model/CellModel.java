package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class CellModel extends AbstractModel<HSSFRow> {
    @Override
    Object createInner(ModelContext context, HSSFRow row) {
        HSSFCell cell = row.createCell(row.getPhysicalNumberOfCells());
        return cell;
    }
}
