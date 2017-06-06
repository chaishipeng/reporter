package com.dianping.vc.reporter.model;

import com.dianping.vc.reporter.model.context.ModelContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaishipeng on 2017/6/6.
 */
public abstract class AbstractModel<T> implements Model<T>{

    private List<Model> childModels = new ArrayList<Model>();

    public void addChild(Model model){
        childModels.add(model);
    }

    public List<Model> getChildModels() {
        return childModels;
    }

    public void setChildModels(List<Model> childModels) {
        this.childModels = childModels;
    }

    public void create(ModelContext context, T t) {
        Object t1 = createInner(context, t);
        childCreate(t1, context);
    }

    protected void childCreate(Object t1, ModelContext context){
        for (Model model : childModels){
            model.create(context, t1);
        }
    }

    abstract Object createInner(ModelContext context, T t);
}
