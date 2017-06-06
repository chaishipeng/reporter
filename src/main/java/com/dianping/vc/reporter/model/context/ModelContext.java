package com.dianping.vc.reporter.model.context;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ModelContext {

    private HSSFWorkbook book;

    private Map data;

    private Object currentData;

    private Map metaData = new HashMap();

    public HSSFWorkbook getBook() {
        return book;
    }

    public void setBook(HSSFWorkbook book) {
        this.book = book;
    }

    public Object getData(String key){
        if (currentData instanceof Map){
            return ((Map)currentData).get(key);
        }
        if (currentData instanceof List) {
            throw new RuntimeException("ParentData is List !!!");
        }
        BeanWrapper beanWrapper = new BeanWrapperImpl(currentData);
        return beanWrapper.getPropertyValue(key);
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
        this.currentData = data;
    }

    public Object getCurrentData() {
        return currentData;
    }

    public void setCurrentData(Object currentData) {
        this.currentData = currentData;
    }

    public Object getMeta(String key){
        return metaData.get(key);
    }

    public void setMeta(String key, Object obj){
        metaData.put(key, obj);
    }
}
