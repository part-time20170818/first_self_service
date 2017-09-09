package com.wr.service.impl;

import com.wr.common.enum1.ConstantsEnum;
import com.wr.common.utils.MD5;
import com.wr.dao.BossUserMapper;
import com.wr.dto.BaseResultBO;
import com.wr.po.BossUser;
import com.wr.service.LoginService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 文歌 on 2017/9/9.
 */
@Service
public class LoginServiceImpl implements LoginService {
    Logger logger =  Logger.getLogger(LoginService. class );
    @Resource
    private BossUserMapper bossUserMapper;
    public BaseResultBO login(BossUser bossUser){
        BaseResultBO resultBO = new BaseResultBO();
        logger.info("【Boss后台登陆】入参："+bossUser);
        if (bossUser == null) {
            resultBO.setCode(ConstantsEnum.DATA_IS_NULL.getCode());
            resultBO.setMsg(ConstantsEnum.DATA_IS_NULL.getMsg());
            return resultBO;
        }
        BossUser requestBo = new BossUser();
        requestBo.setUserName(bossUser.getUserName());
        List<BossUser> userBos = bossUserMapper.selectByExample(requestBo);
        logger.info("【Boss后台登陆】查询用户信息为："+userBos);
        String password = MD5.md5(bossUser.getPassword());
        if (userBos == null || userBos.size() <= 0 || !StringUtils.equals(userBos.get(0).getPassword(),password)) {
            logger.info("【Boss后台登陆】密码错误！");
            resultBO.setCode(ConstantsEnum.LOGIN_PASSWORD_ERROR.getCode());
            resultBO.setMsg(ConstantsEnum.LOGIN_PASSWORD_ERROR.getMsg());
            return resultBO;
        }
       if(!StringUtils.equals(userBos.get(0).getStatus(),ConstantsEnum.TUSER_STATUS.getCode())) {
           logger.info("【Boss后台登陆】用户状态不可用；用户状态为："+userBos.get(0).getStatus());
           resultBO.setCode(ConstantsEnum.USER_STATUS_ERROR.getCode());
           resultBO.setMsg(ConstantsEnum.USER_STATUS_ERROR.getMsg());
           return resultBO;
        }
        resultBO.setObject(userBos.get(0).getUserId());
        resultBO.setCode(ConstantsEnum.SUCCESS.getCode());
        resultBO.setMsg(ConstantsEnum.SUCCESS.getMsg());
        logger.info("【Boss后台登陆】登录成功！");
        return resultBO;
    }

    public BaseResultBO modifyPassword(BossUser bossUser){
        BaseResultBO resultBO = new BaseResultBO();
        logger.info("【Boss后台修改密码】入参："+bossUser);
        if (bossUser == null) {
            resultBO.setCode(ConstantsEnum.DATA_IS_NULL.getCode());
            resultBO.setMsg(ConstantsEnum.DATA_IS_NULL.getMsg());
            return resultBO;
        }
        BossUser userBo = bossUserMapper.selectByPrimaryKey(bossUser.getUserId());
        logger.info("【Boss后台修改密码】查询用户信息为："+userBo);
        if (userBo == null) {
            resultBO.setCode(ConstantsEnum.USER_NOT_EXIT.getCode());
            resultBO.setMsg(ConstantsEnum.USER_NOT_EXIT.getMsg());
            return resultBO;
        }
        String password = MD5.md5(bossUser.getPassword());
        bossUser.setPassword(password);
        bossUser.setGmtModifyPassword(new Date());
        try {
            bossUserMapper.updateByPrimaryKeySelective(bossUser);
        }catch (Exception e){
            logger.info("【Boss后台修改密码】修改密码失败："+e);
            resultBO.setCode(ConstantsEnum.FAILURE.getCode());
            resultBO.setMsg(ConstantsEnum.FAILURE.getMsg());
            return resultBO;
        }
        logger.info("【Boss后台修改密码】修改密码成功");
        resultBO.setCode(ConstantsEnum.SUCCESS.getCode());
        resultBO.setMsg(ConstantsEnum.SUCCESS.getMsg());
        return resultBO;
    }

    public BaseResultBO<BossUser> getUser(String userId){
        logger.info("【Boss后台查询用户信息】用户id："+userId);
        BaseResultBO resultBO = new BaseResultBO();
        BossUser userBo = null;
        try{
            userBo = bossUserMapper.selectByPrimaryKey(userId);
        }catch (Exception e){
            logger.info("【Boss后台查询用户信息】查询用户信息异常："+e);
            resultBO.setCode(ConstantsEnum.FAILURE.getCode());
            resultBO.setMsg(ConstantsEnum.FAILURE.getMsg());
            return resultBO;
        }

        logger.info("【Boss后台查询用户信息】查询用户信息为："+userBo);
        if (userBo == null) {
            logger.info("【Boss后台查询用户信息】用户不存在");
            resultBO.setCode(ConstantsEnum.USER_NOT_EXIT.getCode());
            resultBO.setMsg(ConstantsEnum.USER_NOT_EXIT.getMsg());
            return resultBO;
        }
        resultBO.setCode(ConstantsEnum.SUCCESS.getCode());
        resultBO.setMsg(ConstantsEnum.SUCCESS.getMsg());
        resultBO.setObject(userBo);
        return resultBO;
    }
}
