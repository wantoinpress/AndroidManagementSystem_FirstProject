package zdfwuy.newproject.data_daily;

/**
 * Created by ASUS on 2021/5/10.
 */
public class LoggingInfo {
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String getLoginMachineName() {
        return loginMachineName;
    }

    public void setLoginMachineName(String loginMachineName) {
        this.loginMachineName = loginMachineName;
    }

    Integer pid ;
    String loginName ;
    String userName ;
    String loginTime ;
    String loginIP ;
    String loginMachineName ;
}
