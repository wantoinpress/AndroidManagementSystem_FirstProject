package zdfwuy.newproject.data;


import java.math.BigDecimal;

public class ContractInfo {

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public Integer getEngineerTime() {
        return engineerTime;
    }

    public void setEngineerTime(Integer engineerTime) {
        this.engineerTime = engineerTime;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    Integer pid;

    
    String engineerName;

    
    String numOfItem;

    
    String constructionUnit;

    
    String workUnit;


    Integer engineerTime;


    String contractNum;


    BigDecimal contractMoney;


    String signDate;


    String startDate;


    String endDate;


    String performance;
}
