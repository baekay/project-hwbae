package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.common.AccessTokenHandler;
import kr.ac.hanrw.webapp.dao.UserDao;
import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 9
 * Time: 오후 1:46
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao = null;

    @Override
    public AccessToken registUser(User user) {
        userDao.insertUser(user);
        AccessToken at = AccessTokenHandler.generate(user);
        return at;
    }

    @Override
    public User getUserBy(String userId) {
        User user = userDao.getUserBy(userId);
        return user;
    }

    @Override
    public boolean loginUser(User user) {
        return userDao.loginUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void deleteUsers(String userIDs) {
        userDao.deleteUsers(userIDs);
    }

    @Override
    public List<User> getUserList(SearchCondition searchCondition) {
        List<User> userList = userDao.getUserList(searchCondition);
        return userList;
    }

    @Override
    public int getUserTotalCnt(SearchCondition searchCondition) {
        return userDao.getUserTotalCnt(searchCondition);
    }

    @Override
    public AccessToken genAccessToken(User user) {
        return AccessTokenHandler.generate(user);
    }
}
