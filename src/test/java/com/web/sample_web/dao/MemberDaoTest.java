package com.web.sample_web.dao;

import com.web.sample_web.entity.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDaoTest {

    @Autowired
    MemberDao memberDao;

    @Test
    public void testSaveMember() {
        Member member = new Member("alireza talashan","alirezatl135@gmail.com",
                "alitls","12345678");
        Member saveMember = memberDao.saveMember(member);
        Assert.assertNotNull(saveMember);
    }

    @Test
    public void testGetByUserName() {
        Member alitls = memberDao.getByUserName("alitls");
        Assert.assertEquals("alitls", alitls.getUserName());
    }

    @Test
    public void testGetByUserNameAndPassword() {
        Member user = memberDao.getByUserNameAndPassword("alitls", "12345678");
        Assert.assertEquals("12345678",user.getPassword());
    }

    @Test
    public void testGetAllMember() {
        List<Member> allMember = memberDao.getAllMember();
        Assert.assertEquals(1, allMember.size());
    }

    @Test
    public void testDeleteMemberById() {
        Integer integer = memberDao.deleteMemberById(1);
        Assert.assertEquals(true,integer>0);
    }
}