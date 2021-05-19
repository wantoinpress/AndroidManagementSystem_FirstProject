package zdfwuy.newproject.data_safeguard;

/**
 * Created by ASUS on 2021/5/9.
 */
public class ManagepeopleInfo {
    public String getAffiliatedUnits() {
        return affiliatedUnits;
    }

    public void setAffiliatedUnits(String affiliatedUnits) {
        this.affiliatedUnits = affiliatedUnits;
    }

    public String getCanUse() {
        return canUse;
    }

    public void setCanUse(String canUse) {
        this.canUse = canUse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getRankNum() {
        return rankNum;
    }

    @Override
    public String toString() {
        return "ManagepeopleInfo{" +
                "affiliatedUnits='" + affiliatedUnits + '\'' +
                ", canUse='" + canUse + '\'' +
                ", gender='" + gender + '\'' +
                ", pid=" + pid +
                ", ppName='" + ppName + '\'' +
                ", rankNum='" + rankNum + '\'' +
                ", remarks='" + remarks + '\'' +
                ", telNum='" + telNum + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public void setRankNum(String rankNum) {
        this.rankNum = rankNum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    String affiliatedUnits;
    String canUse;
    String gender;
    Integer pid;
    String ppName;
    String rankNum;
    String remarks;
    String telNum;
    String userName;
    String userRole;
    
    
}
