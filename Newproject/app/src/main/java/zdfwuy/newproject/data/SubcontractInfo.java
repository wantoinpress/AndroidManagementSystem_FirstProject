package zdfwuy.newproject.data;


import java.math.BigDecimal;

public class SubcontractInfo {

    public BigDecimal getAABSS() {
        return AABSS;
    }

    public void setAABSS(BigDecimal AABSS) {
        this.AABSS = AABSS;
    }

    public BigDecimal getAPP() {
        return APP;
    }

    public void setAPP(BigDecimal APP) {
        this.APP = APP;
    }

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

    public String getERPServicePurchaseOrderNumber() {
        return ERPServicePurchaseOrderNumber;
    }

    public void setERPServicePurchaseOrderNumber(String ERPServicePurchaseOrderNumber) {
        this.ERPServicePurchaseOrderNumber = ERPServicePurchaseOrderNumber;
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

    public String getSAOSS() {
        return SAOSS;
    }

    public void setSAOSS(String SAOSS) {
        this.SAOSS = SAOSS;
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

    public String getSubcontractContent() {
        return subcontractContent;
    }

    public void setSubcontractContent(String subcontractContent) {
        this.subcontractContent = subcontractContent;
    }

    public String getSubcontractingType() {
        return subcontractingType;
    }

    public void setSubcontractingType(String subcontractingType) {
        this.subcontractingType = subcontractingType;
    }

    public String getSubcontractNo() {
        return subcontractNo;
    }

    public void setSubcontractNo(String subcontractNo) {
        this.subcontractNo = subcontractNo;
    }

    public String getSubcontractor() {
        return subcontractor;
    }

    public void setSubcontractor(String subcontractor) {
        this.subcontractor = subcontractor;
    }

    public String getWbs() {
        return wbs;
    }

    public void setWbs(String wbs) {
        this.wbs = wbs;
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

    
    String wbs;

    
    String subcontractNo;   //分包合同编号

    
    String ERPServicePurchaseOrderNumber;   //ERP服务采购订单号

    
    String subcontractor;       //分包单位

    
    String subcontractContent;  //分包内容

    
    String subcontractingType;  //分包类型

    
    String signDate;

    
    String startDate;

    
    String endDate;


    BigDecimal contractMoney;


    BigDecimal APP; //累计支付进度款


    BigDecimal AABSS; //分包结算前预提金额

    
    String SAOSS;   //分包结算总金额

    
    String performance;
}
