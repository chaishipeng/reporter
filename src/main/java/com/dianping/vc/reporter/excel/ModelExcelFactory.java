package com.dianping.vc.reporter.excel;

import com.dianping.vc.reporter.model.ExcelModel;
import com.dianping.vc.reporter.model.context.ModelContext;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ModelExcelFactory implements ExcelFactory{

    public void create(ExcelModel excelModel, Map data, OutputStream os) throws IOException {
        ModelContext context = new ModelContext();
        context.setData(data);
        excelModel.create(context, null);
        context.getBook().write(os);
        if (os != null) {
            os.close();
        }
    }

}
