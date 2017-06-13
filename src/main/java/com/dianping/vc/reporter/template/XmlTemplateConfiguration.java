package com.dianping.vc.reporter.template;

import com.dianping.vc.reporter.model.ExcelModel;
import com.dianping.vc.reporter.xmlparse.XmlParse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chaishipeng on 2017/6/7.
 */
public class XmlTemplateConfiguration implements TemplateConfiguration {

    private String basePath;

    private XmlParse xmlParse;

    public Template loadTemplate(InputStream is) throws IOException {
        XmlParse xmlParse = getXmlParse();
        try {
            ExcelModel excelModel = (ExcelModel) xmlParse.read(is);
            XmlTemplate template = new XmlTemplate();
            template.setExcelModel(excelModel);
            return template;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Template loadTemplate(String name) throws IOException {
        if (basePath == null) {
            throw new RuntimeException("Path is not null");
        }
        FileInputStream fileInputStream = new FileInputStream(basePath + name + ".xml");
        return loadTemplate(fileInputStream);
    }

    public void setBasePath(String path) {
        this.basePath = path;
    }

    protected XmlParse getXmlParse(){
        if (xmlParse != null) {
            return xmlParse;
        }
        synchronized (this){
            if (xmlParse != null) {
                return xmlParse;
            }
            xmlParse = new XmlParse();
            xmlParse.init();
            return xmlParse;
        }
    }

}
