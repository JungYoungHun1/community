package com.koreait.community.user;

import com.koreait.community.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity selUser(UserEntity entity);
}
