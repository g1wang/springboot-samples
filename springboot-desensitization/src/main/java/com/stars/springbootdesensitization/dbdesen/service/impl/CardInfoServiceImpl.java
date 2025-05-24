package com.stars.springbootdesensitization.dbdesen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stars.springbootdesensitization.dbdesen.domain.CardInfo;
import com.stars.springbootdesensitization.dbdesen.service.CardInfoService;
import com.stars.springbootdesensitization.dbdesen.mapper.CardInfoMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author wanggl
* @description 针对表【card_info】的数据库操作Service实现
* @createDate 2025-05-17 14:50:40
*/
@Service
public class CardInfoServiceImpl extends ServiceImpl<CardInfoMapper, CardInfo>
    implements CardInfoService{

    /**
     * @param cardInfo
     * @return
     */
    @Override
    public List<CardInfo> listBy(CardInfo cardInfo) {
        return this.getBaseMapper().listBy(cardInfo);
    }
}




