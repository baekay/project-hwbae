package kr.ac.hanrw.webapp.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 14.
 * Time: 오후 11:40
 */
public class Board implements Serializable {

    private  String menuId;
    private int articleId;
    private String userId;
    private int parentArticleId;
    private String subject;
    private boolean isReply;
    private String context;
    private Date createTime;
    private User user;

    private List<Attachment> attachmentList;
    private List<Board> replies;
    private int replyCnt;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getParentArticleId() {
        return parentArticleId;
    }

    public void setParentArticleId(int parentArticleId) {
        this.parentArticleId = parentArticleId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    @JsonProperty("isReply")
    public boolean isReply() {
        return isReply;
    }

    @JsonProperty("isReply")
    public void setReply(boolean reply) {
        isReply = reply;
    }


    public boolean getIsReply()
    {
        return isReply;
    }


    public void setIsReply(boolean replay) {
        isReply = replay;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Board> getReplies() {
        return replies;
    }

    public void setReplies(List<Board> replies) {
        this.replies = replies;
    }

    public int getReplyCnt() {
        return replyCnt;
    }

    public void setReplyCnt(int replyCnt) {
        this.replyCnt = replyCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (articleId != board.articleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return articleId;
    }

    @Override
    public String toString() {
        return "Board{" +
                "menuId='" + menuId + '\'' +
                ", articleId=" + articleId +
                ", userId='" + userId + '\'' +
                ", parentArticleId=" + parentArticleId +
                ", subject='" + subject + '\'' +
                ", isReply=" + isReply +
                ", context='" + context + '\'' +
                ", createTime=" + createTime +
                ", replyCnt=" + replyCnt +
                '}';
    }
}
