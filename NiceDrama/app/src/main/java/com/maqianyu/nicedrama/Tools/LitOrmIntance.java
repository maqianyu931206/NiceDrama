package com.maqianyu.nicedrama.Tools;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.maqianyu.nicedrama.map.quickhead.LiteOrmBean;
import com.maqianyu.nicedrama.myset.bean.LiteOrmLogInBean;

import java.util.List;

/**
 * Created by dllo on 16/10/25.
 */
public class LitOrmIntance {
    private LiteOrm liteOrm;


    public LitOrmIntance() {
       liteOrm = LiteOrm.newSingleInstance(MyApp.getContext(),"nicedrama.db");
        liteOrm.setDebugged(true);
    }
    private static LitOrmIntance litOrmIntance;

    public static LitOrmIntance getIntance() {
        if (litOrmIntance == null) {
            synchronized (LitOrmIntance.class) {
                if (litOrmIntance == null) {
                    litOrmIntance = new LitOrmIntance();
                }
            }
        }
        return litOrmIntance;
    }
    // 插入一条数据
    public void insertOne(LiteOrmBean liteOrmBean) {
        LiteOrmBean lb = new LiteOrmBean();
        lb.setTitle(liteOrmBean.getTitle());
        lb.setImgUrl(liteOrmBean.getImgUrl());
        lb.setUrl(liteOrmBean.getUrl());
        liteOrm.insert(lb);
    }

    // 查询所有数据
    public <T> List<T> getQueryAll(Class<T> cla) {
        return liteOrm.query(cla);
    }

    // 按条件查询,删除一条数据
    public void deleteOne(Object title) {
        WhereBuilder lb = new WhereBuilder(LiteOrmBean.class);
        lb.where("title = ?", new Object[]{title});
        liteOrm.delete(lb);
    }

    // 查询一条数据
    public List<LiteOrmBean> queryOne(Object title) {
        QueryBuilder<LiteOrmBean> lb = new QueryBuilder<LiteOrmBean>(LiteOrmBean.class);
        lb.where("title = ?", new Object[]{title});
        return  liteOrm.query(lb);
    }
    /*************登录*******************/
    /**
     * 插入一条数据
     */
    public void insert(LiteOrmLogInBean sq) {
        liteOrm.insert(sq);
    }
    /**
     * 根据条件查询
     */
    public List<LiteOrmLogInBean> queryByName(String name) {
        QueryBuilder<LiteOrmLogInBean> qb = new QueryBuilder<>(LiteOrmLogInBean.class);
        qb.where("name = ?", name);
        return liteOrm.query(qb);
    }

    /**
     * 根据电话号码查询
     * @param number
     * @return
     */
    public List<LiteOrmLogInBean> queryByNumber(String number) {
        QueryBuilder<LiteOrmLogInBean> qb = new QueryBuilder<>(LiteOrmLogInBean.class);
        qb.where("number = ?", number);
        return liteOrm.query(qb);
    }
    /**
     * 按条件删除
     */
    public void deleteByName(String name) {
        WhereBuilder wb = new WhereBuilder(LiteOrmLogInBean.class);
        wb.where("name = ?", name);
        liteOrm.delete(wb);
    }

}
