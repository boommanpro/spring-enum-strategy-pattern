package com.boommanpro.springenumstrategypattern.module.report.controller;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.service.GeneratorReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqimeng
 * @date 2020/5/4 18:47
 */
@RestController
@RequestMapping("api/report")
public class ReportController {

    private final GeneratorReportService generatorReportService;

    public ReportController(GeneratorReportService generatorReportService) {
        this.generatorReportService = generatorReportService;
    }

    @GetMapping("generatorReport")
    public String generatorReport(@RequestParam String dataId, @RequestParam ProcessType type) {
        generatorReportService.generatorReport(dataId, type);
        return "SUCCESS";
    }
}
