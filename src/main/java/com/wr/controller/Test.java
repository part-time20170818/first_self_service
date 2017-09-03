package com.wr.controller;

import com.wr.common.utils.IpUtil;
import com.wr.domain.User;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by 文歌 on 2017/9/2.
 */
public class Test{
    public static void main(String[] arg) throws SocketException, UnknownHostException {
        User user = new User();
        user.setIp(IpUtil.getLocalIP());
        System.out.print(user.getIp());
    }

}
