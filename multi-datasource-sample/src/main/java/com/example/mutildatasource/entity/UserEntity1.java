package com.example.mutildatasource.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:03
 */
@Data
@Entity
@Table(name = "user_info", schema = "recsys")
public class UserEntity1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String sex;
    private Integer age;
    private BigDecimal score;
}
