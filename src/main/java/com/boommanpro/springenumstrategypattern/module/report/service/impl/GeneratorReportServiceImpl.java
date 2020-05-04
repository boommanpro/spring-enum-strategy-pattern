package com.boommanpro.springenumstrategypattern.module.report.service.impl;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.service.GeneratorReportService;
import org.springframework.stereotype.Service;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:08
 */
@Service
public class GeneratorReportServiceImpl implements GeneratorReportService {

    @Override
    public void generatorReport(String dataId,ProcessType type) {
        type.generatorReport(dataId);
    }
}
