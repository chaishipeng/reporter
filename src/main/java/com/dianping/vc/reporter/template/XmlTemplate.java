package com.dianping.vc.reporter.template;

import com.dianping.vc.reporter.excel.ModelExcelFactory;
import com.dianping.vc.reporter.model.ExcelModel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/7.
 */
public class XmlTemplate implements Template {

    private ModelExcelFactory modelExcelFactory = new ModelExcelFactory();

    private ExcelModel excelModel;

    public void setExcelModel(ExcelModel excelModel) {
        this.excelModel = excelModel;
    }

    public void export(OutputStream os, Map data) throws IOException {
        modelExcelFactory.create(excelModel, data, os);
    }
}
