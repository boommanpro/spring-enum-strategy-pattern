package com.boommanpro.springenumstrategypattern.module.report.enums;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.GeneratorReport;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:07
 */
@Slf4j
@Getter
public enum ProcessType implements GeneratorReport {
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

    private static EnumMap<ProcessType, GeneratorReport> generatorReportMap;

    ProcessType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void generatorReport(String dataId) {
        Optional.ofNullable(generatorReportMap.get(this)).orElseThrow(() -> new RuntimeException("没有找到实现的bean" + this)).generatorReport(dataId);
    }

    @Component
    public static class ProcessTypeGeneratorReportConfig implements ApplicationContextAware {

        private ProcessTypeGeneratorReportConfig() {
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            initGeneratorReportMap(applicationContext);
        }

        private void initGeneratorReportMap(ApplicationContext applicationContext) {
            //获取所有关于GeneratorReport的bean
            Map<String, GeneratorReport> beanMap = applicationContext.getBeansOfType(GeneratorReport.class);
            EnumMap<ProcessType, GeneratorReport> result = new EnumMap<>(ProcessType.class);
            beanMap.forEach((s, generatorReport) -> {
                ProcessTypeEnumFlag annotation = AnnotationUtils.findAnnotation(generatorReport.getClass(), ProcessTypeEnumFlag.class);
                if (annotation == null) {
                    return;
                }
                ProcessType value = annotation.value();
                result.put(value, generatorReport);
            });

            setGeneratorReportMap(result);
        }

        private static void setGeneratorReportMap(EnumMap<ProcessType, GeneratorReport> generatorReportMap) {
            ProcessType.generatorReportMap = generatorReportMap;
        }

    }
}
