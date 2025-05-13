package com.stars.springbatch.config;

import com.stars.springbatch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/13 9:25
 */
@Component
public class SalaryValidatorProcessor implements ItemProcessor<Employee, Employee> {
    private static final BigDecimal MIN_SALARY = new BigDecimal("3000");

    @Override
    public Employee process(Employee item) throws Exception {
        // 数据校验
        if (item.getAge() < 18) {
            throw new IllegalArgumentException("未成年员工: " + item);
        }

        // 数据转换
        item.setDepartment(item.getDepartment().toUpperCase());

        // 薪资过滤
        if (BigDecimal.valueOf(item.getSalary()).compareTo(MIN_SALARY) < 0) {
            return null; // 过滤低薪资记录
        }

        return item;
    }
}
