package zdfwuy.newproject.data;


import java.math.BigDecimal;

public class PublicInfo {

    Integer pid;
   
    String engeenirName;
   
    String companyType;
   
    String buildCompany;
   
    String numOfItem;
   
    String wbs;

    BigDecimal money;
   
    String workCompany;
   
    Integer workYear;
   
    String isFin;
   
    String originalNum;

    public String getBuildCompany() {
        return buildCompany;
    }

    public void setBuildCompany(String buildCompany) {
        this.buildCompany = buildCompany;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getEngeenirName() {
        return engeenirName;
    }

    public void setEngeenirName(String engeenirName) {
        this.engeenirName = engeenirName;
    }

    public String getIsFin() {
        return isFin;
    }

    public void setIsFin(String isFin) {
        this.isFin = isFin;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public String getOriginalNum() {
        return originalNum;
    }

    public void setOriginalNum(String originalNum) {
        this.originalNum = originalNum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getWbs() {
        return wbs;
    }

    public void setWbs(String wbs) {
        this.wbs = wbs;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }
}
