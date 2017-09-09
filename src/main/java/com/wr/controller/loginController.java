package com.wr.controller;

import com.alibaba.fastjson.JSON;
import com.wr.common.JsonUtil;
import com.wr.common.enum1.ConstantsEnum;
import com.wr.common.utils.IpUtil;
import com.wr.common.utils.MD5;
import com.wr.domain.User;
import com.wr.dto.BaseResultBO;
import com.wr.dto.LoginBO;
import com.wr.dto.ModifyPasswdBO;
import com.wr.po.BossUser;
import com.wr.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

/**
 * Created by 文歌 on 2017/9/3.
 */
@Controller
@RequestMapping(value = "/user", method = { RequestMethod.POST, RequestMethod.GET })
public class loginController {
    Logger logger =  Logger.getLogger(loginController. class );
    @Resource
    private com.wr.service.LoginService LoginService;
    @ResponseBody
    @RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
    public BaseResultBO<String> login(LoginBO bo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("login data : "+bo);
        BaseResultBO<String> resultBO = new  BaseResultBO<String>();
        try {
            HttpSession session=request.getSession();
            String checkData = (String)session.getAttribute("number");
            if (!StringUtils.endsWithIgnoreCase(checkData,bo.getCheckNumber())) {
                logger.info("【Boss后台登录】校验验证码错误：用户输入："+bo.getCheckNumber()+",系统："+checkData);
                resultBO.setCode(ConstantsEnum.LOGIN_CHECK_NUMBER_ERROR.getCode());
                resultBO.setMsg(ConstantsEnum.LOGIN_CHECK_NUMBER_ERROR.getMsg());
                return resultBO;
            }
            BossUser user = new BossUser();
            user.setPassword(bo.getPassWord());
            user.setUserName(bo.getUserName());
            resultBO = LoginService.login(user);
        } catch (Exception e) {
            logger.info("【Boss后台登录】登录失败："+e);
            resultBO.setCode(ConstantsEnum.FAILURE.getCode());
            resultBO.setMsg(ConstantsEnum.FAILURE.getMsg());
            return resultBO;
        }
        return resultBO;
    }
    @ResponseBody
    @RequestMapping(value = "updatePassword", method = { RequestMethod.POST, RequestMethod.GET })
    public BaseResultBO modify(ModifyPasswdBO bo, HttpServletRequest request, HttpServletResponse response) {
        BaseResultBO resultBO = new BaseResultBO();
        logger.info("【Boss后台修改密码】入参 : "+bo);
        BaseResultBO<BossUser> userBos = LoginService.getUser(bo.getUserId());
        logger.info("【Boss后台修改密码】查询用户信息出参："+userBos);
        if(userBos == null || userBos.getObject() == null ){
            resultBO.setCode(ConstantsEnum.USER_NOT_EXIT.getCode());
            resultBO.setMsg(ConstantsEnum.USER_NOT_EXIT.getMsg());
            return resultBO;
        }
        BossUser bossUser = userBos.getObject();
        String password = MD5.md5(bo.getOriginalPasswd());
        if (!StringUtils.equals(password,bossUser.getPassword())) {
            resultBO.setCode(ConstantsEnum.LOGIN_CHECK_NUMBER_ERROR.getCode());
            resultBO.setMsg(ConstantsEnum.LOGIN_CHECK_NUMBER_ERROR.getMsg());
            return resultBO;
        }
        BossUser requestBo = new BossUser();
        requestBo.setUserId(bo.getUserId());
        requestBo.setPassword(bo.getNewPasswd());
        logger.info("【Boss后台修改密码】调用修改密码入参 : "+requestBo);
        BaseResultBO returnBo = LoginService.modifyPassword(requestBo);
        return returnBo;

    }
}
