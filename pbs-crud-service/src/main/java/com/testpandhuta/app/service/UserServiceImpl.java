package com.testpandhuta.app.service;

import com.testpandhuta.app.entity.UserEntity;
import com.testpandhuta.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity Post(UserEntity params) {
        userRepository.save(params);
        return params;
    }

    @Override
    public List<UserEntity> Get() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity Get(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity Update(UserEntity params, long id) {

        UserEntity user =  userRepository.findById(id).get();
        user.setUsername(params.getUsername());
        user.setPassword(params.getPassword());

        return userRepository.save(user);

    }

    @Override
    public String Delete(long id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}