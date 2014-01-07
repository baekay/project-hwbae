package kr.ac.hanrw.webapp.service;


import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.dto.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 9.
 * Time: 오전 12:16
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public AccessToken registUser(User user);
    public User getUserBy(String userId);
    public boolean loginUser(User user);
    public void updateUser(User user);
    public void deleteUser(String userId);
    public void deleteUsers(String userIDs);
    public List<User> getUserList(SearchCondition searchCondition);
    public int getUserTotalCnt(SearchCondition searchCondition);
    public AccessToken genAccessToken(User user);
}
