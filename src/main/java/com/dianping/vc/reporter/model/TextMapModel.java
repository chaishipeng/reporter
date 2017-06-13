package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/13.
 */
public class TextMapModel extends TextModel{

    private Map<String, String> mappedRule;

    public Map<String, String> getMappedRule() {
        return mappedRule;
    }

    public void setMappedRule(Map<String, String> mappedRule) {
        this.mappedRule = mappedRule;
    }

    @Override
    void fillValue(HSSFCell hssfCell, Object value, ModelContext context) {
        if (value == null){
            value = context.getCurrentData();
        }
        hssfCell.setCellValue(mappedRule.get(value) + "");
    }

}
