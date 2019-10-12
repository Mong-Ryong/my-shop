package com.ml.my.shop.web.admin.service.test;

import com.ml.my.shop.domain.TbUser;
import com.ml.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }

    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("ddd");
        tbUser.setPhone("1588888888");
        tbUser.setEmail("ml@qq.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));//一种加密方式
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.save(tbUser);

    }

    @Test
    public void testDelete() {
        tbUserService.delete(39L);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("XML");
        tbUserService.update(tbUser);
    }

    @Test
    public void testSelectByUsername() {
        List<TbUser> tbUsers = tbUserService.selectByUsername("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void MD5() {
        System.out.println(DigestUtils.md5DigestAsHex("admin".getBytes()));
    }


}
