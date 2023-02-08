package com.stars.springmvc.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@Data
public class User {
    //用户名
    @Column(name = "username")
    private String username;

    //密码
    @Column(name = "password")
    private String password;

    //用户id
    @Id
    @Column(name = "id")
    private long id;

    //昵称
    @Column(name = "nickname")
    private String nickname;


}
