package zdfwuy.newproject.data;

import java.math.BigDecimal;

public class SettlementInfo {
    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
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

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getNotReportedReview() {
        return notReportedReview;
    }

    public void setNotReportedReview(String notReportedReview) {
        this.notReportedReview = notReportedReview;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public String getPendingAccountAfterAudit() {
        return pendingAccountAfterAudit;
    }

    public void setPendingAccountAfterAudit(String pendingAccountAfterAudit) {
        this.pendingAccountAfterAudit = pendingAccountAfterAudit;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getPostAuditAmount() {
        return postAuditAmount;
    }

    public void setPostAuditAmount(BigDecimal postAuditAmount) {
        this.postAuditAmount = postAuditAmount;
    }

    public String getReportAudit() {
        return reportAudit;
    }

    public void setReportAudit(String reportAudit) {
        this.reportAudit = reportAudit;
    }

    public String getReportBudgetDepartment() {
        return reportBudgetDepartment;
    }

    public void setReportBudgetDepartment(String reportBudgetDepartment) {
        this.reportBudgetDepartment = reportBudgetDepartment;
    }

    public String getReportConstructionUnit() {
        return reportConstructionUnit;
    }

    public void setReportConstructionUnit(String reportConstructionUnit) {
        this.reportConstructionUnit = reportConstructionUnit;
    }

    public BigDecimal getSettlementPreparationAmount() {
        return settlementPreparationAmount;
    }

    public void setSettlementPreparationAmount(BigDecimal settlementPreparationAmount) {
        this.settlementPreparationAmount = settlementPreparationAmount;
    }

    Integer pid;

    
    String engineerName;

    
    String numOfItem;

    
    String constructionUnit;

    
    String workUnit;


    Integer engineerTime;


    BigDecimal settlementPreparationAmount;

    
    String notReportedReview;       //?????????

    
    String reportConstructionUnit;  //???????????????

    
    String reportBudgetDepartment;  //???????????????

    
    String reportAudit;             //?????????

    
    String pendingAccountAfterAudit;    //???????????????

    
    String account;                 //??????


    BigDecimal postAuditAmount;         //????????????


    BigDecimal invoiceAmount;           //????????????

}
