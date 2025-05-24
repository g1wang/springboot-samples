package com.stars.springbootdesensitization.dbdesen.controller;

import com.stars.springbootdesensitization.dbdesen.domain.CardInfo;
import com.stars.springbootdesensitization.dbdesen.service.CardInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/16 17:03
 */
@RestController
@RequestMapping("card-info")
public class CardInfoController {

    @Resource
    private CardInfoService cardInfoService;

    @PostMapping
    public String addCardInfo(@RequestBody CardInfo cardInfo) {
        cardInfoService.save(cardInfo);
        return "success";
    }

    @GetMapping("list")
    public List<CardInfo> getCardInfoList(CardInfo cardInfo) {
        return cardInfoService.listBy(cardInfo);
    }

}
