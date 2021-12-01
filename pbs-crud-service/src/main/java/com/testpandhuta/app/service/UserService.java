package com.testpandhuta.app.service;


import com.testpandhuta.app.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    UserEntity Post(UserEntity params);

    List<UserEntity> Get();

    UserEntity Get(long id);

    UserEntity Update(UserEntity params, long id);

    String Delete(long id);


}
