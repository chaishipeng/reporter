package com.dianping.vc.reporter;

import com.dianping.vc.reporter.template.Template;
import com.dianping.vc.reporter.template.TemplateConfiguration;
import com.dianping.vc.reporter.template.XmlTemplateConfiguration;
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
        params.put("name", "adasa");
        params.put("age", "12");
        params.put("sex", "1");
        list.add(params);

        Map params2 = new HashMap();
        params2.put("name", "trfsc");
        params2.put("age", "17");
        params2.put("sex", "1");
        list.add(params2);

        Map params3 = new HashMap();
        params3.put("name", "09xna");
        params3.put("age", "26");
        params3.put("sex", "2");
        list.add(params3);

        data.put("List", list);


        TemplateConfiguration templateConfiguration = new XmlTemplateConfiguration();
        Template template = templateConfiguration.loadTemplate(new FileInputStream("/Users/chaishipeng/lifeCode/reporter/src/test/java/com/dianping/vc/reporter/template.xml"));

        template.export(new FileOutputStream("/Users/chaishipeng/TempFile/test" + System.currentTimeMillis() + ".xls"), data);

    }

}
