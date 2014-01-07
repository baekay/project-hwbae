package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.dto.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 8.
 * Time: 오후 9:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    /**
     * 사용자 등록
     * @param user 사용자 등록 정보
     * @return등록된 등록성공여부
     */
    public void insertUser(User user);

    /**
     * 사용자 로그인
     * @param user 로그인 정보
     * @return 로그인 결과
     */
    public boolean loginUser(User user);

    /**
     * 사용자 정보 조회
     * @param userId 조회할 아이디
     * @return 사용자 정보
     */
    public User getUserBy(String userId);

    /**
     * 사용자 목록 조회
     * @param userSearchCondition 사용자 목록 조회 조건
     * @return 사용자 목록
     */
    public List<User> getUserList(SearchCondition userSearchCondition);

    /**
     * 총 사용자 수 반환.
     * @param userSearchCondition
     * @return
     */
    public int getUserTotalCnt(SearchCondition userSearchCondition);



    /**
     * 사용자 정보 수정
     * @param user 수정할 사용자 정보
     * @return 수정성공여부
     */
    public void updateUser(User user);

    /**
     * 사용자 삭제
     * @param userId 삭제할 사용자 아이디
     * @return 삭제성공여부
     */
    public void deleteUser(String userId);
    public void deleteUsers(String userIDs);
}
