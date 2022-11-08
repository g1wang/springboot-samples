package com.stars.excelsample.controller;


import com.stars.excelsample.entity.Query;
import com.stars.excelsample.entity.UserEntity;
import com.stars.excelsample.service.UserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.DefaultTempFileCreationStrategy;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 16:56
 */
@RestController
@RequestMapping("/excel/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @GetMapping("list")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @GetMapping("export")
    public void export(HttpServletResponse resp, Query query, HttpServletRequest request) throws UnsupportedEncodingException {
        String fileDownloadName = "excel-export-demo.xlsx";
        String userAgent = request.getHeader("User-Agent").toLowerCase();

        if (userAgent.contains("msie") || userAgent.contains("trident") || userAgent.contains("like gecko") || userAgent.contains("edge")) {
            //IE浏览器
            fileDownloadName = URLEncoder.encode(fileDownloadName, "UTF-8");
            //处理文件名多余的加号（+）
            fileDownloadName = fileDownloadName.replaceAll("\\+", "%20");
        } else {
            //其它浏览器
            fileDownloadName = new String(fileDownloadName.getBytes("UTF-8"), "ISO-8859-1");
        }
        resp.addHeader("Content-Disposition", "attachment;filename=" + fileDownloadName);
        resp.setContentType("application/msexcel;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        OutputStream os = null;
        long startTime = System.currentTimeMillis();
        try {
            int startRow = 0;
            int lines = 100;
            query.setLines(lines);
            int epoch = 0;
            int epochSize = 1000;
            String[] title = {"用户ID", "性别", "年龄", "评分"};
            SXSSFWorkbook wk = new SXSSFWorkbook(1000);
            //每一批导出数量 1000
            List<UserEntity> list = null;
            Sheet sheet = wk.createSheet();
            Row row = sheet.createRow(0);
            for (int i = 0; i < title.length; i++) {
                row.createCell(i).setCellValue(title[i]);
            }
            do {
                if (startRow - epoch * epochSize >= epochSize) {
                    //标题
                    epoch++;
                    sheet = wk.createSheet();
                    row = sheet.createRow(0);
                    for (int i = 0; i < title.length; i++) {
                        row.createCell(i).setCellValue(title[i]);
                    }
                }
                //数据内容 分页查询
                query.setStartRow(startRow);
                list = userService.export(query);
                long exportDiff = System.currentTimeMillis() - startTime;
                LOG.warn("数据库查询耗时(秒)：" + exportDiff / (1000));
                CellStyle doubleStyle = wk.createCellStyle();
                doubleStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("#,##0.00"));
                CellStyle doubleStyle4 = wk.createCellStyle();
                doubleStyle4.setDataFormat((short) BuiltinFormats.getBuiltinFormat("#,####0.0000"));
                CellStyle intStyle = wk.createCellStyle();
                intStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("#,#0"));
                if (!CollectionUtils.isEmpty(list)) {
                    UserEntity data;
                    int rowCount = list.size();
                    for (int i = 0; i < rowCount; i++) {
                        data = list.get(i);
                        row = sheet.createRow(startRow - epoch * epochSize + i + 1);
                        CellUtil.createCell(row, 0, String.valueOf(data.getUserId()));
                        CellUtil.createCell(row, 1, data.getSex());
                        Cell ageCell = CellUtil.createCell(row, 2, "");
                        ageCell.setCellStyle(intStyle);
                        ageCell.setCellValue(data.getAge());
                        Cell scoutCell = CellUtil.createCell(row, 3, "");
                        if (data.getScore() != null) {
                            scoutCell.setCellStyle(doubleStyle);
                            scoutCell.setCellValue(data.getScore().doubleValue());
                        }
                    }
                    startRow += rowCount;
                }
            } while (list != null && list.size() != 0);
            os = resp.getOutputStream();
            wk.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                }
            }
            long diff = System.currentTimeMillis() - startTime;
            LOG.warn("导出耗时(秒)：" + diff / (1000));
        }
    }





}
