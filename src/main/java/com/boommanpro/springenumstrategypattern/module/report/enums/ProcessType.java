package com.boommanpro.springenumstrategypattern.module.report.enums;

import com.boommanpro.springenumstrategypattern.common.EnumBeanMapUtil;
import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.GeneratorReport;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:07
 */
@Slf4j
@Getter
public enum ProcessType implements GeneratorReport{
    /**
     * 查询报告
     */
    QUERY_PROCESS("查询流程", "查询流程报告描述"),

    /**
     * 关注报告
     */
    FOCUS_PROCESS("关注流程", "关注流程报告描述");

    private final String name;

    private final String desc;

    private static Map<ProcessType, GeneratorReport> generatorReportMap;


    ProcessType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void generatorReport(String dataId) {
        Optional.ofNullable(generatorReportMap.get(this)).orElseThrow(() -> new RuntimeException("没有找到实现的bean" + this)).generatorReport(dataId);
    }

    @Component
    public static class ProcessTypeGeneratorReportConfig implements ApplicationContextAware, InitializingBean {

        private ProcessTypeGeneratorReportConfig() {
        }

        private ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) {
            this.applicationContext=applicationContext;
        }

        private void initGeneratorReportMap() {
            //获取所有关于GeneratorReport的bean
            Map<String, GeneratorReport> beanMap = applicationContext.getBeansOfType(GeneratorReport.class);
            Map<ProcessType, GeneratorReport> result = EnumBeanMapUtil.beanMap2EnumMap(beanMap, ProcessTypeEnumFlag.class, ProcessTypeEnumFlag::value);
            setGeneratorReportMap(result);
        }

        private static void setGeneratorReportMap(Map<ProcessType, GeneratorReport> generatorReportMap) {
            ProcessType.generatorReportMap = generatorReportMap;
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            initGeneratorReportMap();
        }
    }
}
