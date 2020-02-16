package com.tom.common.listener;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 19:49
 */
@Component
public class CommonItemWriteListener implements ItemWriteListener {

    @Override
    public void beforeWrite(List list) {

    }

    @Override
    public void afterWrite(List list) {

    }

    @Override
    public void onWriteError(Exception e, List list) {

    }
}
