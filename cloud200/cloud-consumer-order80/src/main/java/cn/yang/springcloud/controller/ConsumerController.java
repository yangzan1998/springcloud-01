package cn.yang.springcloud.controller;

import cn.yang.springcloud.domain.Payment;
import cn.yang.springcloud.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;
    private final String PAYMENT_URL= "http://localhost:8001";
    @GetMapping("/consumer/creat")
    public Result<Payment> creat(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"payment/creat/",payment, Result.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public Result<Payment> findById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id, Result.class);
    }
}
