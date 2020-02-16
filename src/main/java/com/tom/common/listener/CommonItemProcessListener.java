package com.tom.common.listener;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 19:49
 */
@Component
public class CommonItemProcessListener implements ItemProcessListener {

    @Override
    public void beforeProcess(Object o) {
        System.out.println("CommonItemProcessListener -> beforeProcess : " + o.toString());
    }

    @Override
    public void afterProcess(Object o, Object o2) {
        System.out.println("CommonItemProcessListener -> afterProcess : " + o.toString() + " -> " + o2.toString());
    }

    @Override
    public void onProcessError(Object o, Exception e) {
        System.out.println("CommonItemProcessListener -> onProcessError : " + e);
    }
}
