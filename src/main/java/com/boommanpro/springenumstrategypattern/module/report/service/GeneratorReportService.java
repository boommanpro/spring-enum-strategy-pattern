package com.boommanpro.springenumstrategypattern.module.report.service;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:08
 */
public interface GeneratorReportService {

     void generatorReport(String dataId,ProcessType type);
}
