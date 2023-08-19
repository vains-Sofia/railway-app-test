package com.example.task;

import com.example.exchange.MineExchange;
import com.example.model.Result;
import com.example.model.response.CaptchaResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 为back4app部署准备的定时任务，每25分钟执行一次
 *
 * @author vains
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class HeartBeatTask {
    
    private final MineExchange mineExchange;
    
    /**
     * 每25分钟请求一下当前服务
     */
    @Scheduled(fixedDelay = 28L, timeUnit = TimeUnit.MINUTES)
    public void keepServerLive() {
        try {
            Result<CaptchaResult> result = mineExchange.getCaptcha();
            log.info("调用当前服务成功，返回：{}", result.getData().getCode());
        } catch (Exception e) {
            log.error("调用当前服务失败，原因：{}", e.getMessage());
        }
    }
    
}