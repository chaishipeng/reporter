package com.dianping.vc.reporter;

import com.dianping.vc.reporter.excel.ModelExcelFactory;
import com.dianping.vc.reporter.model.CellModel;
import com.dianping.vc.reporter.model.ExcelModel;
import com.dianping.vc.reporter.model.RowModel;
import com.dianping.vc.reporter.model.SheetModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class PoiTest {

    public static void main(String[] args) throws IOException {
        ModelExcelFactory modelExcelFactory = new ModelExcelFactory();
        Map data = new HashMap();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        data.put("List", list);
        modelExcelFactory.create(getModel(), data, new FileOutputStream("/Users/chaishipeng/TempFile/test" + System.currentTimeMillis() + ".xls"));
    }

    private static ExcelModel getModel(){
        ExcelModel excelModel = new ExcelModel();

        SheetModel sheetModel = new SheetModel();
        sheetModel.setName("ceshi");
        excelModel.addChild(sheetModel);

        RowModel rowModel = new RowModel();
        rowModel.setRepeat("List");
        sheetModel.addChild(rowModel);

        CellModel cellModel = new CellModel();
        rowModel.addChild(cellModel);

        /*ValueModel valueModel = new ValueModel();
        cellModel.addChild(valueModel);*/

        return excelModel;
    }

}
