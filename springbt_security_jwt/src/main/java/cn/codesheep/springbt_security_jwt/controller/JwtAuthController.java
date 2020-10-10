package cn.codesheep.springbt_security_jwt.controller;

import cn.codesheep.springbt_security_jwt.comm.Const;
import cn.codesheep.springbt_security_jwt.model.entity.User;
import cn.codesheep.springbt_security_jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @www.codesheep.cn
 * 20190312
 */
@RestController
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        return authService.login( username, password );
    }

    // 注册
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register( @RequestBody User addedUser ) throws AuthenticationException {
//        List<String> defaultRoles = Arrays.asList(Const.DEFAULT_ROLES);
        //TODO 已注册则返回
        addedUser.setRolesByName(Const.DEFAULT_ROLES);
        return authService.register(addedUser);
    }

}
