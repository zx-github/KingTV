package com.csizg.rxjava.greendao;

import android.content.Context;
import android.content.Intent;

import com.csizg.rxjava.Main2Activity;
import com.csizg.rxjava.MyApp;
import com.csizg.rxjava.Utils.LogUtil;
import com.csizg.rxjava.dao.greendao.DaoMaster;
import com.csizg.rxjava.dao.greendao.DaoSession;
import com.csizg.rxjava.dao.greendao.UserDao;
import com.csizg.rxjava.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2018/4/13.
 *
 * @description：
 */

public class DaoManager {
    private static DaoManager manager;
    private UserDao userDao;
    private List<User> users;

    public static DaoManager getManager() {
        if (null == manager) {
            manager = new DaoManager();
        }
        return manager;
    }

    public DaoManager() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(MyApp.getmContext(), "lenve.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }

    public void testGreenDao() {
        insert();
        query();
        deleteByName();
        query();
        delete();
        query();
    }

    public void startActivity() {
        Context context = MyApp.getmContext();
        Intent intent = new Intent(context, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public boolean insert() {
        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(null, "zhangsan" + i, "张三"));
        }
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                userDao.insert(user);
            }
        }
        return true;
    }

    public boolean delete() {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Id.le(5)).build().list();
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
                LogUtil.d("", "delete", "Username: " + user.getUsername());
                ;
                userDao.delete(user);
            }
        }
        return true;
    }

    public boolean deleteByName() {
        //id要大于等于10，同是还要满足username like %90%，注意最后的unique表示只查询一条数据出来即可
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Username.eq("zhangsan3")).build().list();
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
                LogUtil.d("", "deleteByName", "Username: " + user.getUsername());
                ;
                userDao.delete(user);
            }

        } else {
            LogUtil.e("", "deleteByName", "zhangsan3: 不存在");
            ;
        }
        return true;
    }

    public boolean query() {
        //between表示查询id介于2到13之间的数据，limit表示查询5条数据
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Id.between(2, 13)).limit(5).build().list();
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
                LogUtil.d("", "query", "Username: " + user.getUsername());
            }
        } else {
            LogUtil.e("", "query", "数据不存在");
            ;
        }
        list.clear();
        list = userDao.queryBuilder().build().list();
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
                LogUtil.d("", "query", "Username: " + user.getUsername());
                ;
            }
        } else {
            LogUtil.e("", "query", "数据不存在");
            ;
        }
        return true;
    }


}
