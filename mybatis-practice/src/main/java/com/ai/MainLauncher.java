package com.ai;

import com.ai.dao.DataOutputMappingDao;
import com.ai.entity.DataOutputMapping;
import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : kevin
 * @version : Ver 1.0
 * @description :
 * @date : 2017/8/11
 */
public class MainLauncher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
//        DataUserDao dataUserDao = applicationContext.getBean(DataUserDao.class);
//        DataUser dataUser = new DataUser();
//        dataUser.setUsername("admin");
//        List<DataUser> dataUsers = dataUserDao.findByCondition(dataUser);
//        System.out.println(dataUsers);
//        System.out.println("===");
//        System.out.println(dataUserDao.findByCondition(dataUser));;
//
//        DataLogDao dataLogDao = applicationContext.getBean(DataLogDao.class);
//        DataLog dataLog = dataLogDao.getByIdFully(10L);
//        System.out.println(dataLog);


        // lazy
        DataOutputMappingDao dataOutputMappingDao = applicationContext.getBean(DataOutputMappingDao.class);
//        DataOutputMapping dataOutputMapping = dataOutputMappingDao.getByIdFully(31L);
//        System.out.println(JSON.toJSONString(dataOutputMapping));

        // 延迟加载的本质是针对子查询的
        // 延迟加载的关键就是代理，如果发现有嵌套的对象进行代理的延迟加载
        DataOutputMapping dataOutputMapping = dataOutputMappingDao.getById(31L);
        System.out.println("before :" + JSON.toJSONString(dataOutputMapping));
        dataOutputMapping.getDataSourceOutput();
        System.out.println("after :" + JSON.toJSONString(dataOutputMapping));





//        System.out.println(dataLogDao.findByCondition(dataLog));
    }
}
