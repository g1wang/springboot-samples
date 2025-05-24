package com.stars.springbootsharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stars.springbootsharding.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wanggl
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2025-05-23 14:24:38
* @Entity com.stars.springbootsharding.domain.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




