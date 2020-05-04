package com.boommanpro.springenumstrategypattern.module.report.service.generatorreport;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:07
 */
public interface GeneratorReport {

    /**
     * 根据dataId生成报告
     *
     * @param dataId 数据id
     */
    void generatorReport(String dataId);
}
