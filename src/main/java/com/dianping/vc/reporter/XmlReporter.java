package com.dianping.vc.reporter;

import com.dianping.vc.reporter.excel.ModelExcelFactory;
import com.dianping.vc.reporter.model.ExcelModel;
import com.dianping.vc.reporter.xmlparse.XmlParse;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class XmlReporter implements Reporter {

    private ExcelModel excelModel;

    private ModelExcelFactory modelExcelFactory = new ModelExcelFactory();

    public void loadTemplate(InputStream is) throws IOException, SAXException, ParserConfigurationException {
        XmlParse xmlParse = new XmlParse();
        xmlParse.init();
        excelModel = (ExcelModel) xmlParse.read(is);
    }

    public void write(OutputStream os, Map data) throws IOException {
        modelExcelFactory.create(excelModel, data, os);
    }
}
