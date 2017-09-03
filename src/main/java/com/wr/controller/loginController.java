package com.wr.controller;

import com.alibaba.fastjson.JSON;
import com.wr.common.JsonUtil;
import com.wr.common.enum1.ConstantsEnum;
import com.wr.common.utils.IpUtil;
import com.wr.domain.User;
import com.wr.dto.BaseResultBO;
import com.wr.dto.LoginBO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;

/**
 * Created by 文歌 on 2017/9/3.
 */
@Controller
@RequestMapping(value = "/user", method = { RequestMethod.POST, RequestMethod.GET })
public class loginController {
    Logger logger =  Logger.getLogger(loginController. class );
    @ResponseBody
    @RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
    public BaseResultBO login(LoginBO bo, HttpServletRequest bindingResult, HttpServletResponse response) {
        logger.info("login data : "+bo);
        BaseResultBO resultBO = new BaseResultBO();
        resultBO.setCode(ConstantsEnum.SUCCESS.getCode());
        resultBO.setMsg(ConstantsEnum.SUCCESS.getMsg());
        return resultBO;
    }
}
