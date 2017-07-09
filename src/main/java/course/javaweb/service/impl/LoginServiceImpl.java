package course.javaweb.service.impl;

import course.javaweb.dao.UserDao;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(User user) {

        User userInfo = userDao.getUserInfo(user);

        if (userInfo != null) {
            if (userInfo.getPassword().equals(user.getPassword())) {

                BeanUtils.copyProperties(userInfo, user);
                return true;
//                System.out.println("2: "+user.getNickname());
//                System.out.println("2: "+user.getUserName());
//                System.out.println("db: "+userInfo.getNickname());
//                System.out.println("db: "+userInfo.getUserName());
            }
        }
        return false;
    }
}