package com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.impl;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessTypeEnumFlag;
import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.GeneratorReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:18
 */
@Slf4j
@Service
@ProcessTypeEnumFlag(ProcessType.QUERY_PROCESS)
public class QueryProcessGeneratorReportService implements GeneratorReport {

    @Override
    public void generatorReport(String dataId) {
        log.info("生成查询报告,报告Id:[{}]",dataId);
    }
}
