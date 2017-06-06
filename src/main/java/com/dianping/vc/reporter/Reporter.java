package com.dianping.vc.reporter;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public interface Reporter {

    void loadTemplate(InputStream is) throws IOException, SAXException, ParserConfigurationException;

    void write(OutputStream os, Map data) throws IOException;

}
