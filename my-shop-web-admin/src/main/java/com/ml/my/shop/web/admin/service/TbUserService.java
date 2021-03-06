package com.ml.my.shop.web.admin.service;

import com.ml.my.shop.commons.dto.BaseResult;
import com.ml.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();

    BaseResult save(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
