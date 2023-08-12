package com.technical.terchnicalsummary.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @title NacosController
 * @description
 * @create 2023/8/12 13:51
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    /**
     * 配置中心
     */
    @NacosValue(value = "${spring.datasource.driver-class-name:com.mysql.jdbc.Driver}", autoRefreshed = true)
    private String springSDataSourceDriverClassName;

    @RequestMapping(value = "/getConfig", method = RequestMethod.GET)
    public Object getConfig() {
        return springSDataSourceDriverClassName;
    }

    /**
     * 服务器注册
     */

    @NacosInjected
    private NamingService namingService;
    @RequestMapping("/getInstance/{serviceName}")
    public List<Instance> getInstance(@PathVariable("serviceName") String serviceName) {
        List<Instance> allInstances = null;
        try {
            allInstances = namingService.getAllInstances(serviceName);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return allInstances;
    }
}
