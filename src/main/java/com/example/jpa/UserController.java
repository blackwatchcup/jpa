package com.example.jpa;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path = "/add")
    @ApiOperation(value = "新增一个用户", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功保存"),
            @ApiResponse(code = 401, message = "你没权限"),
            @ApiResponse(code = 403, message = "你被禁止访问了"),
            @ApiResponse(code = 404, message = "没找到，哈哈哈")
    }
    )
    @ApiImplicitParam(name = "user",
            value = "要新增的用户",
            dataType = "User",//This can be the class name or a primitive
            required = true,
            paramType = "body")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "ok";
    }
    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}