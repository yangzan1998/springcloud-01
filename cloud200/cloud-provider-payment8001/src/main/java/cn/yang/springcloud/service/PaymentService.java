package cn.yang.springcloud.service;

import cn.yang.springcloud.domain.Payment;
import cn.yang.springcloud.domain.Result;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    Result create(Payment payment);

    Payment findById(@Param("id") Long id);
}
