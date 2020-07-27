package cn.yang.springcloud.controller;

import cn.yang.springcloud.domain.Payment;
import cn.yang.springcloud.domain.Result;
import cn.yang.springcloud.service.PaymentService;
import cn.yang.springcloud.service.impl.PaymentServiceImpl;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PaymentController {
    @Resource
    private PaymentServiceImpl paymentService;
    @ResponseBody
    @PostMapping(value = "payment/creat")
    public Result creat(Payment payment){
        Result result = paymentService.create(payment);
        return result;
    }
    @ResponseBody
    @GetMapping(value = "/payment/get/{id}")
    public Result findById(@PathVariable("id")Long id){
        Payment payment = paymentService.findById(id);
        if (payment!=null){
            return new Result(200,"查询用户成功",payment);
        }else{
            return new Result(444,"查询用户失败",null);
        }
    }

}
