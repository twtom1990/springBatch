package com.tom.service;

import com.tom.bean.RequestBean;
import com.tom.bean.ResponseBean;
import com.tom.common.http.CommonHttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-03-01
 * Time: 17:30
 */
@Service
public class BatchService {

    @Autowired
    private CommonHttpUtils commonHttpUtils;


    public boolean postData(){
        RequestBean rb = new RequestBean();
        return commonHttpUtils.postData("http://localhost:8080/batch/api/v1/test",rb,ResponseBean.class);
    }
}
