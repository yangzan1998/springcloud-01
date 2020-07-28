package cn.yang.springcloud.service.impl;

import cn.yang.springcloud.dao.PaymentDao;
import cn.yang.springcloud.domain.Payment;
import cn.yang.springcloud.domain.Result;
import cn.yang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public Result create(Payment payment) {
        Logger log=LoggerFactory.getLogger(getClass());
        int i = paymentDao.create(payment);
        log.info("-------创建订单返回结果"+i);
        if (i!=0){
            return  new Result(200,"用户创建成功");
        }else {
        return new Result(444,"创建订单失败");
        }

    }

    @Override
    public Payment findById( @Param("id") Long id) {
        Payment payment = paymentDao.findById(id);
        return payment;
    }
}
