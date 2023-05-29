package com.xxx.warehouse;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomSwagger2
@EnableCustomConfig
@EnableRyFeignClients
@SpringBootApplication
@MapperScan(basePackages = "com/xxx/warehouse/mapper")
public class xxxWarehouseApplication {
    public static void main(String[] args){
        SpringApplication.run(xxxWarehouseApplication.class,args);
        System.out.println("库存管理模块启动成功！！！");
    }
}
