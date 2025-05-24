package com.stars.springbootdesensitization.dbdesen.mapper;

import com.stars.springbootdesensitization.dbdesen.domain.CardInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author wanggl
* @description 针对表【card_info】的数据库操作Mapper
* @createDate 2025-05-17 14:50:40
* @Entity com.stars.springbootdesensitization.dbdesen.domain.CardInfo
*/
@Mapper
public interface CardInfoMapper extends BaseMapper<CardInfo> {

    List<CardInfo> listBy(CardInfo cardInfo);
}




