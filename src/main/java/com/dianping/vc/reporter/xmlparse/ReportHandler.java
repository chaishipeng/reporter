package com.dianping.vc.reporter.xmlparse;

import com.dianping.vc.reporter.model.Model;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ReportHandler extends DefaultHandler {

    private ModelFactory factory;

    private Stack<Model> stack = new Stack<Model>();

    private Model root;

    public void setFactory(ModelFactory factory) {
        this.factory = factory;
    }

    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)throws SAXException {
        Model model = factory.createModel(qName, attributes);
        stack.push(model);
    }

    public void endElement (String uri, String localName, String qName)
            throws SAXException{
        Model model = stack.pop();
        if (stack.isEmpty()){
            root = model;
            return;
        }
        Model parentModel = stack.peek();
        parentModel.addChild(model);
    }

    public Model getRoot() {
        return root;
    }
}
