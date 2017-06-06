package com.dianping.vc.reporter.xmlparse;

import com.dianping.vc.reporter.xmlparse.handler.*;
import com.dianping.vc.reporter.model.Model;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class XmlParse {

    private ModelFactory modelFactory;

    public Model read(InputStream is) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        ReportHandler reportHandler = getReportHandler();
        saxParser.parse(is, reportHandler);
        return reportHandler.getRoot();
    }

    private ReportHandler getReportHandler(){
        ReportHandler reportHandler = new ReportHandler();
        reportHandler.setFactory(modelFactory);
        return reportHandler;
    }

    public void init(){
        modelFactory = new ModelFactory();
        modelFactory.registerHandler("excel", new ExcelHandler());
        modelFactory.registerHandler("sheet", new SheetHandler());
        modelFactory.registerHandler("row", new RowHandler());
        modelFactory.registerHandler("cell", new CellHandler());
        modelFactory.registerHandler("text", new TextHandler());
        modelFactory.registerHandler("date", new DateHandler());
        modelFactory.registerHandler("style", new StyleHandler());
        modelFactory.registerHandler("font", new FontHandler());
    }

}
