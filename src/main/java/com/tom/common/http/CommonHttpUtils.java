package com.tom.common.http;

import com.tom.bean.RequestBean;
import com.tom.bean.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-03-01
 * Time: 17:34
 */
@Slf4j
@Component
public class CommonHttpUtils {

    @Autowired
    private RestTemplate restTemplate;
//    exceptionExpression="#{message.contains('this can be retried')}"
    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1))
    public boolean postData(String url, RequestBean requestBean, Class clazz) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("p1", new Date().toString());
        httpHeaders.add("p2", "123");
        HttpEntity<RequestBean> httpEntity = new HttpEntity<RequestBean>(requestBean, httpHeaders);
        ResponseEntity<ResponseBean> responseBean = restTemplate.postForEntity(url, httpEntity.toString(), clazz);
        //org.springframework.web.client.RestClientException: No HttpMessageConverter for com.tom.bean.RequestBean
//        ResponseEntity<ResponseBean> responseBean = restTemplate.postForEntity(url, httpEntity, clazz);

        log.info(responseBean.getBody().getId().toString());
        throw new RuntimeException();
//        return true;
    }

    @Recover
    public boolean recover(Exception e, String url, RequestBean requestBean, Class clazz) {
        log.error("重试机制3次完成，结果依然异常.." + e);
        return true;
    }
}
