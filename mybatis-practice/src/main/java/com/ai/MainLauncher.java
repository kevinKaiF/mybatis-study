package com.ai;

import com.ai.dao.DataLogDao;
import com.ai.dao.DataUserDao;
import com.ai.entity.DataLog;
import com.ai.entity.DataUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author : kevin
 * @version : Ver 1.0
 * @description :
 * @date : 2017/8/11
 */
public class MainLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        DataUserDao dataUserDao = applicationContext.getBean(DataUserDao.class);
        DataUser dataUser = new DataUser();
        dataUser.setUsername("admin");
        List<DataUser> dataUsers = dataUserDao.findByCondition(dataUser);
        System.out.println(dataUsers);
        System.out.println("===");
        System.out.println(dataUserDao.findByCondition(dataUser));;

        DataLogDao dataLogDao = applicationContext.getBean(DataLogDao.class);
        DataLog dataLog = dataLogDao.getById(10L);
        System.out.println(dataLog);


        System.out.println(dataLogDao.findByCondition(dataLog));
    }
}
