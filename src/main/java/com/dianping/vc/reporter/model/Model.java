package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public interface Model<T> {

    void create(ModelContext context, T t);

    void addChild(Model model);

}
