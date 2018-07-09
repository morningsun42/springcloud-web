package com.example.web;

import com.example.dto.MVCResult;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.utils.BPwdEncoderUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "注册", notes = "username和password为必选项")
    @PostMapping(value = "/registry")
    public MVCResult createUser(@RequestBody Map<String, Object> user) {
        String username = String.valueOf(user.get("username"));
        String password = String.valueOf(user.get("password"));
        String realname = String.valueOf(user.get("realname"));
        String authorities = String.valueOf(user.get("authorities"));

        User userinfo = new User();
        userinfo.setUsername(username);
        userinfo.setRealname(realname);
        userinfo.setPassword(BPwdEncoderUtils.BCryptPassword(password));
        List<Role> roles = new ArrayList<>();
        String[] aulst = authorities.split(",");
        for (String au : aulst) {
            Role role = new Role();
            role.setName(au.toUpperCase());
            roles.add(role);
        }
        userinfo.setAuthorities(roles);
        User result = userService.createUser(userinfo);
        if (result == null)
            return MVCResult.create(result, "账号已经存在，请更换其他账号！");
        return MVCResult.create(result);
    }

    @ApiOperation(value = "登录", notes = "username和password为必选项")
    @PostMapping("/login")
    public MVCResult login(@RequestParam String username, @RequestParam String password) {
        //参数判读省略
        return userService.login(username, password);
    }

    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @PostMapping("/{username}")
    @PreAuthorize("hasRole('USER')")
    // @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public MVCResult getUserInfo(@PathVariable("username") String username) {
        //参数判读省略
        User user = userService.getUserInfo(username);
        return MVCResult.create(user);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表信息")
    @PostMapping("/userlist")
    @PreAuthorize("hasRole('USER')")
    public MVCResult getUserInfoList() {
        return MVCResult.create(userService.getUserInfoList());
    }

    @ApiOperation(value = "根据用户名删除用户", notes = "根据用户名删除用户")
    @PostMapping("/delete/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public MVCResult removeUser(@PathVariable("username") String username) {
        return MVCResult.create(userService.removeUser(username));
    }
}
