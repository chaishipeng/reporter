package com.dianping.vc.reporter.template;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/7.
 */
public interface Template {

    void export(OutputStream os, Map data) throws IOException;

}
