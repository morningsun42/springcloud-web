package com.example.service;

import com.example.client.AuthServiceClient;
import com.example.client.UaaServiceClient;
import com.example.dao.UserDao;
import com.example.dto.MVCResult;
import com.example.entity.User;
import com.example.exception.CommonException;
import com.example.exception.ErrorCode;
import com.example.utils.BPwdEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    AuthServiceClient authServiceHystrix;

    @Autowired
    UaaServiceClient uaaServiceHystrix;

    public User createUser(User user) {
        uaaServiceHystrix.addUser(user);
        return userDao.save(user);
    }

    public User getUserInfo(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> getUserInfoList() {
        return userDao.findUsers();
    }

    public MVCResult login(String username, String password) {
        String error = "";
        Map<String, Object> jwt = null;
        User user = userDao.findByUsername(username);
        if (null == user) {
            error = new CommonException(ErrorCode.USER_NOT_FOUND).getMsg();
        } else if (!BPwdEncoderUtils.matches(password, String.valueOf(user.getPassword()))) {
            error = new CommonException(ErrorCode.USER_PASSWORD_ERROR).getMsg();
        } else {
            jwt = authServiceHystrix.getToken("Basic dWFhLXNlcnZpY2U6MTIzNDU2", "password", username, password);
            // 获得用户菜单
            if (null == jwt) {
                error = new CommonException(ErrorCode.GET_TOKEN_FAIL).getMsg();
            }
            Map<String, Object> userDto = new HashMap<>();
            userDto.put("user", user);
            userDto.put("token", jwt.get("access_token"));
            return MVCResult.create(userDto, error);
        }


        if (!"".equals(error)) {
            System.out.println(error);
        }

        return MVCResult.create(null, error);
    }

    public boolean removeUser(String username) {
        return userDao.removeByUsername(username);
    }
}
