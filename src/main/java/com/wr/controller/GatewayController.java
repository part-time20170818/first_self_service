package com.wr.controller;

import com.wr.common.utils.IpUtil;
import com.wr.domain.User;
import com.wr.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by xiewenge on 2017/7/21.
 */
@Controller
@RequestMapping(value = "/gateway", method = { RequestMethod.POST, RequestMethod.GET })
public class GatewayController {
    Logger logger =  Logger.getLogger(GatewayController. class );

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView gateway(HttpServletRequest bindingResult, HttpServletResponse response) {
        logger.info("这是我的测试请你打印出来");
        logger.error("这是error级别的日志打印");
        ModelAndView mav = new ModelAndView("test");
        User user = userService.selectUserById("1");
        logger.info("user:"+user);
        user.setUserName("解文歌");
        InetAddress address = null;
        try {
           user.setIp(IpUtil.getLocalIP());
        } catch (Exception e) {
            logger.info(e.getMessage());

        }
        logger.info("user:"+user.getIp());
        mav.addObject("user", user);
        return mav;
    }

}
