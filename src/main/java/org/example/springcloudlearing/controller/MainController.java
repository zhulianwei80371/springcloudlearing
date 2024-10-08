package org.example.springcloudlearing.controller;


import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.springcloudlearing.dto.UserDto;
import org.example.springcloudlearing.dto.UserFormDto;
import org.example.springcloudlearing.entity.vip.User;
import org.example.springcloudlearing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
@Api(tags ="用户管理结偶")
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping(path="/saveUser") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody UserFormDto userFormDto) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User one = new User();
        one.setName(userFormDto.getName());
        one.setEmail(userFormDto.getEmail());
        userService.save(one);
        return "Saved";
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public @ResponseBody String deleteUser (@ApiParam("用户id") @PathVariable String id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.removeById(id);
        return "deleted";
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("/getById/{id}")
    public UserDto queryUserById (@ApiParam("用户id") @PathVariable String id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User user = userService.getById(id);
        return BeanUtil.copyProperties(user, UserDto.class);
    }
    @ApiOperation("根据id批量查询用户")
    @GetMapping
    public List<UserDto> getAllUsers(@ApiParam("用户id集合") @RequestParam("ids")List<String> ids) {
        // This returns a JSON or XML with the users
        List<User> users = userService.listByIds(ids);
        return BeanUtil.copyToList(users,UserDto.class);
    }

    @ApiOperation("根据id扣减用户余额")
    @PutMapping("/{id}/deduction/{amount}")
    public String deduction(@ApiParam("用户id") @PathVariable("id") String id,
                     @ApiParam("扣减金额") @PathVariable("amount") String amount) {
        // This returns a JSON or XML with the users
        userService.updateBalance(id,new BigDecimal(amount));

        return "updated";
    }

    @ApiOperation("新增用户")
    @GetMapping(path="/queryUsers") // Map ONLY POST Requests
    public List<UserDto> queryUsers (UserFormDto userFormDto) {

        List<User> users = userService.queryUsers(userFormDto.getName(),userFormDto.getBalance(),userFormDto.getEmail());
        return BeanUtil.copyToList(users,UserDto.class);
    }

    @ApiOperation("根据id扣减用户余额")
    @PutMapping("/{id}/deductionLamda/{amount}")
    public String deductionLamda(@ApiParam("用户id") @PathVariable("id") String id,
                            @ApiParam("扣减金额") @PathVariable("amount") String amount) {
        // This returns a JSON or XML with the users
        userService.deductBalanceLamda(id,new BigDecimal(amount));

        return "updated";
    }
}