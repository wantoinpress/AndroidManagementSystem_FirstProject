package zdfwuy.newproject.data_analysis;

/**
 * Created by ASUS on 2021/5/8.
 */
public class AnaLysisInFo {
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public Integer getEngineerTime() {
        return engineerTime;
    }

    public void setEngineerTime(Integer engineerTime) {
        this.engineerTime = engineerTime;
    }

    public String getIsPostContract() {
        return isPostContract;
    }

    public void setIsPostContract(String isPostContract) {
        this.isPostContract = isPostContract;
    }

    public String getIsAbnormalSubcontractDate() {
        return isAbnormalSubcontractDate;
    }

    public void setIsAbnormalSubcontractDate(String isAbnormalSubcontractDate) {
        this.isAbnormalSubcontractDate = isAbnormalSubcontractDate;
    }

    public String getIsSettlementLaggingBehind() {
        return isSettlementLaggingBehind;
    }

    public void setIsSettlementLaggingBehind(String isSettlementLaggingBehind) {
        this.isSettlementLaggingBehind = isSettlementLaggingBehind;
    }

    Integer pid;


    String engineerName;


    String numOfItem;


    String workUnit;


    Integer engineerTime;

    String isPostContract;

    String isAbnormalSubcontractDate;

    String isSettlementLaggingBehind;

}
