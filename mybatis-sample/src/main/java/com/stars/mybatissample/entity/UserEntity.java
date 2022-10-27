package com.stars.mybatissample.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:03
 */
@Data
@Entity
@Table(name = "user_info", schema = "recsys_schema")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String sex;
    private Integer age;
}
