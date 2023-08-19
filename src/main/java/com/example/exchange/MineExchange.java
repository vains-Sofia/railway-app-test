package com.example.exchange;

import com.example.model.Result;
import com.example.model.response.CaptchaResult;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * 为back4app部署准备的接口，调用当前服务
 *
 * @author vains
 */
@HttpExchange
public interface MineExchange {
    
    @GetExchange("/getCaptcha")
    Result<CaptchaResult> getCaptcha();
    
}