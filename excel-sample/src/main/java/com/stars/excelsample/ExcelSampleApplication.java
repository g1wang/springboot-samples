package com.stars.excelsample;

import org.apache.poi.util.DefaultTempFileCreationStrategy;
import org.apache.poi.util.TempFile;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication
@MapperScan("com.stars.excelsample.mapper")
public class ExcelSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelSampleApplication.class, args);
    }

    @Component
    public class ExcelConfig {

        @Value("${application.tmp.path}")
        private String applicationTmpPath;

        /**
         * 设置使用SXSSFWorkbook对象导出excel报表时，TempFile使用的临时目录，代替{java.io.tmpdir}
         */
        @PostConstruct
        public void setExcelSXSSFWorkbookTmpPath() {
            String excelSXSSFWorkbookTmpPath = applicationTmpPath + "/poifiles";
            File dir = new File(excelSXSSFWorkbookTmpPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            TempFile.setTempFileCreationStrategy(new DefaultTempFileCreationStrategy(dir));
        }
    }
}
