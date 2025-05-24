package com.stars.springbootdesensitization.dbdesen.service;

import com.stars.springbootdesensitization.dbdesen.domain.CardInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wanggl
* @description 针对表【card_info】的数据库操作Service
* @createDate 2025-05-17 14:50:40
*/
public interface CardInfoService extends IService<CardInfo> {

    List<CardInfo> listBy(CardInfo cardInfo);
}
