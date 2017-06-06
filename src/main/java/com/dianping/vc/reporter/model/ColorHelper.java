package com.dianping.vc.reporter.model;

import org.apache.poi.hssf.util.HSSFColor;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public class ColorHelper {

    private static Map<String, Short> desc2IndexMap = new HashMap();

    static {
        desc2IndexMap.put("black", HSSFColor.BLACK.index);
        desc2IndexMap.put("red", HSSFColor.RED.index);
        desc2IndexMap.put("blue", HSSFColor.BLUE.index);
        desc2IndexMap.put("yellow", HSSFColor.YELLOW.index);
        desc2IndexMap.put("green", HSSFColor.GREEN.index);
    }

    public static short getColor(String desc){
        if (desc == null) {
            return HSSFColor.BLACK.index;
        }
        if (desc2IndexMap.containsKey(desc)) {
            return desc2IndexMap.get(desc);
        }
        return HSSFColor.BLACK.index;
    }

}
