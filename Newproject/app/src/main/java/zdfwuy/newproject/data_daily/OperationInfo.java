package zdfwuy.newproject.data_daily;

/**
 * Created by ASUS on 2021/5/10.
 */
public class OperationInfo {
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOprationName() {
        return oprationName;
    }

    public void setOprationName(String oprationName) {
        this.oprationName = oprationName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogOrigin() {
        return logOrigin;
    }

    public void setLogOrigin(String logOrigin) {
        this.logOrigin = logOrigin;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    Integer pid;
    String  oprationName;
    String  userName;
    String  logTime;
    String  logType ;
    String  logOrigin ;
    String  logContent ;
}
