package com.koreait.community.user;

import com.koreait.community.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;


    public int idChk(String uid){
        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        UserEntity result = mapper.selUser(entity);
        if(result != null){
            return 0;
        }
        return 1;
    }

}
