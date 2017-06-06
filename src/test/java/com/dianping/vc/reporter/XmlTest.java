package com.dianping.vc.reporter;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class XmlTest {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        Map data = new HashMap();
        List list = new ArrayList();

        Map params = new HashMap();
        params.put("Testket", "TestValue1");
        list.add(params);

        Map params2 = new HashMap();
        params2.put("Testket", "TestValue2");
        list.add(params2);

        Map params3 = new HashMap();
        params3.put("Testket", "TestValue3");
        list.add(params3);

        data.put("List", list);


        XmlReporter xmlReporter = new XmlReporter();
        xmlReporter.loadTemplate(new FileInputStream("/Users/chaishipeng/code/reportman/src/test/java/com/dianping/vc/reportman/template.xml"));
        xmlReporter.write(new FileOutputStream("/Users/chaishipeng/TempFile/test" + System.currentTimeMillis() + ".xls"), data);

    }

}
