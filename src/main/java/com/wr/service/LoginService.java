package com.wr.service;

import com.wr.dto.BaseResultBO;
import com.wr.po.BossUser;

/**
 * Created by 文歌 on 2017/9/9.
 */
public interface LoginService {
    public BaseResultBO login(BossUser bossUser);
    public BaseResultBO modifyPassword(BossUser bossUser);
    public BaseResultBO<BossUser> getUser(String userId);
}
