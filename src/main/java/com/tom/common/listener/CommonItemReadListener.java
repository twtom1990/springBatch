package com.tom.common.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 19:47
 */
@Component
public class CommonItemReadListener implements ItemReadListener {
    @Override
    public void beforeRead() {
        System.out.println("CommonReaderListener -> beforeRead ");
    }

    @Override
    public void afterRead(Object o) {
        System.out.println("CommonReaderListener -> afterRead : " + o.toString());
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("CommonReaderListener -> onReadError : " + e);
    }
}
