package com.boommanpro.springenumstrategypattern.module.report.service;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述
 * Created by Y.S.K on 2020/5/5 0:33
 */
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneratorReportServiceTest {
    @Autowired
    private GeneratorReportService generatorReportService;

    @Test
    public void testGeneratorReport() {
        generatorReportService.generatorReport("123", ProcessType.QUERY_PROCESS);
    }
}