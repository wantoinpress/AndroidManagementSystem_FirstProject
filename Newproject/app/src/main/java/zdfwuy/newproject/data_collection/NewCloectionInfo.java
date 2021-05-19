package zdfwuy.newproject.data_collection;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ASUS on 2021/5/11.
 */
public class NewCloectionInfo implements Serializable {
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

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    @Override
    public String toString() {
        return "NewCloectionInfo{" +
                "pid=" + pid +
                ", engineerName='" + engineerName + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", numOfItem='" + numOfItem + '\'' +
                ", investMoney=" + investMoney +
                ", workUnit='" + workUnit + '\'' +
                ", isFin='" + isFin + '\'' +
                ", contractNum='" + contractNum + '\'' +
                ", contractMoney=" + contractMoney +
                ", signDate='" + signDate + '\'' +
                ", contractStartDate='" + contractStartDate + '\'' +
                ", contractEndDate='" + contractEndDate + '\'' +
                ", budgetMoney=" + budgetMoney +
                ", laborCost=" + laborCost +
                ", consumptionCost=" + consumptionCost +
                ", mechanicsCost=" + mechanicsCost +
                ", takeCost=" + takeCost +
                ", workStartDate='" + workStartDate + '\'' +
                ", workEndDate='" + workEndDate + '\'' +
                ", planEndperiod='" + planEndperiod + '\'' +
                ", engineerMainMessage='" + engineerMainMessage + '\'' +
                ", thisWeekCompleteProcess='" + thisWeekCompleteProcess + '\'' +
                ", engineerTotalProcess='" + engineerTotalProcess + '\'' +
                ", restProcess='" + restProcess + '\'' +
                ", nextWeekPlan='" + nextWeekPlan + '\'' +
                ", monthProduceVal=" + monthProduceVal +
                ", monthAMaterial=" + monthAMaterial +
                ", monthAdBeforeIncome=" + monthAdBeforeIncome +
                ", monthAdBehindIncome=" + monthAdBehindIncome +
                ", yearProduceVal=" + yearProduceVal +
                ", yearAMaterial=" + yearAMaterial +
                ", yearAdBeforeIncome=" + yearAdBeforeIncome +
                ", yearAdBehindIncome=" + yearAdBehindIncome +
                ", transpotCost=" + transpotCost +
                ", fuelCost=" + fuelCost +
                ", laborSubcontracting=" + laborSubcontracting +
                ", earthworkServices=" + earthworkServices +
                ", antiCorrosionService=" + antiCorrosionService +
                ", localEarthwork=" + localEarthwork +
                ", mechanicServices=" + mechanicServices +
                ", professionalSubcontracting=" + professionalSubcontracting +
                ", otherSubcontracting=" + otherSubcontracting +
                ", anticorrosionTeamCost=" + anticorrosionTeamCost +
                ", municipalAdministration=" + municipalAdministration +
                ", other=" + other +
                ", marginalProfit=" + marginalProfit +
                ", marginalProfitRate=" + marginalProfitRate +
                ", settlementPreparationAmount='" + settlementPreparationAmount + '\'' +
                ", notReportedReview='" + notReportedReview + '\'' +
                ", reportConstructionUnit='" + reportConstructionUnit + '\'' +
                ", reportBudgetDepartment='" + reportBudgetDepartment + '\'' +
                ", reportAudit='" + reportAudit + '\'' +
                ", pendingAccountAfterAudit='" + pendingAccountAfterAudit + '\'' +
                ", account='" + account + '\'' +
                ", postAuditAmount='" + postAuditAmount + '\'' +
                ", invoiceAmount='" + invoiceAmount + '\'' +
                ", subcontractNo='" + subcontractNo + '\'' +
                ", subcontractor='" + subcontractor + '\'' +
                ", subcontractContent='" + subcontractContent + '\'' +
                ", subcontractingType='" + subcontractingType + '\'' +
                ", subcontractSignDate='" + subcontractSignDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", subcontractContractMoney=" + subcontractContractMoney +
                ", performance='" + performance + '\'' +
                ", costTotal='" + costTotal + '\'' +
                ", bmaterial='" + bmaterial + '\'' +
                ", metalWorkshopCost=" + metalWorkshopCost +
                ", ansanAntiCorrosionAndPrefabrication=" + ansanAntiCorrosionAndPrefabrication +
                ", costAdjustment=" + costAdjustment +
                ", hrequipment='" + hrequipment + '\'' +
                ", app=" + app +
                ", aabss=" + aabss +
                ", saoss='" + saoss + '\'' +
                ", erpservicePurchaseOrderNumber='" + erpservicePurchaseOrderNumber + '\'' +
                ", amaterialCost=" + amaterialCost +
                ", bmaterialCost=" + bmaterialCost +
                '}';
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getIsFin() {
        return isFin;
    }

    public void setIsFin(String isFin) {
        this.isFin = isFin;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getBudgetMoney() {
        return budgetMoney;
    }

    public void setBudgetMoney(BigDecimal budgetMoney) {
        this.budgetMoney = budgetMoney;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getConsumptionCost() {
        return consumptionCost;
    }

    public void setConsumptionCost(BigDecimal consumptionCost) {
        this.consumptionCost = consumptionCost;
    }

    public BigDecimal getMechanicsCost() {
        return mechanicsCost;
    }

    public void setMechanicsCost(BigDecimal mechanicsCost) {
        this.mechanicsCost = mechanicsCost;
    }

    public BigDecimal getTakeCost() {
        return takeCost;
    }

    public void setTakeCost(BigDecimal takeCost) {
        this.takeCost = takeCost;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(String workEndDate) {
        this.workEndDate = workEndDate;
    }

    public String getPlanEndperiod() {
        return planEndperiod;
    }

    public void setPlanEndperiod(String planEndperiod) {
        this.planEndperiod = planEndperiod;
    }

    public String getEngineerMainMessage() {
        return engineerMainMessage;
    }

    public void setEngineerMainMessage(String engineerMainMessage) {
        this.engineerMainMessage = engineerMainMessage;
    }

    public String getThisWeekCompleteProcess() {
        return thisWeekCompleteProcess;
    }

    public void setThisWeekCompleteProcess(String thisWeekCompleteProcess) {
        this.thisWeekCompleteProcess = thisWeekCompleteProcess;
    }

    public String getEngineerTotalProcess() {
        return engineerTotalProcess;
    }

    public void setEngineerTotalProcess(String engineerTotalProcess) {
        this.engineerTotalProcess = engineerTotalProcess;
    }

    public String getRestProcess() {
        return restProcess;
    }

    public void setRestProcess(String restProcess) {
        this.restProcess = restProcess;
    }

    public String getNextWeekPlan() {
        return nextWeekPlan;
    }

    public void setNextWeekPlan(String nextWeekPlan) {
        this.nextWeekPlan = nextWeekPlan;
    }

    public BigDecimal getMonthProduceVal() {
        return monthProduceVal;
    }

    public void setMonthProduceVal(BigDecimal monthProduceVal) {
        this.monthProduceVal = monthProduceVal;
    }

    public BigDecimal getMonthAMaterial() {
        return monthAMaterial;
    }

    public void setMonthAMaterial(BigDecimal monthAMaterial) {
        this.monthAMaterial = monthAMaterial;
    }

    public BigDecimal getMonthAdBeforeIncome() {
        return monthAdBeforeIncome;
    }

    public void setMonthAdBeforeIncome(BigDecimal monthAdBeforeIncome) {
        this.monthAdBeforeIncome = monthAdBeforeIncome;
    }

    public BigDecimal getMonthAdBehindIncome() {
        return monthAdBehindIncome;
    }

    public void setMonthAdBehindIncome(BigDecimal monthAdBehindIncome) {
        this.monthAdBehindIncome = monthAdBehindIncome;
    }

    public BigDecimal getYearProduceVal() {
        return yearProduceVal;
    }

    public void setYearProduceVal(BigDecimal yearProduceVal) {
        this.yearProduceVal = yearProduceVal;
    }

    public BigDecimal getYearAMaterial() {
        return yearAMaterial;
    }

    public void setYearAMaterial(BigDecimal yearAMaterial) {
        this.yearAMaterial = yearAMaterial;
    }

    public BigDecimal getYearAdBeforeIncome() {
        return yearAdBeforeIncome;
    }

    public void setYearAdBeforeIncome(BigDecimal yearAdBeforeIncome) {
        this.yearAdBeforeIncome = yearAdBeforeIncome;
    }

    public BigDecimal getYearAdBehindIncome() {
        return yearAdBehindIncome;
    }

    public void setYearAdBehindIncome(BigDecimal yearAdBehindIncome) {
        this.yearAdBehindIncome = yearAdBehindIncome;
    }

    public BigDecimal getTranspotCost() {
        return transpotCost;
    }

    public void setTranspotCost(BigDecimal transpotCost) {
        this.transpotCost = transpotCost;
    }

    public BigDecimal getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(BigDecimal fuelCost) {
        this.fuelCost = fuelCost;
    }

    public BigDecimal getLaborSubcontracting() {
        return laborSubcontracting;
    }

    public void setLaborSubcontracting(BigDecimal laborSubcontracting) {
        this.laborSubcontracting = laborSubcontracting;
    }

    public BigDecimal getEarthworkServices() {
        return earthworkServices;
    }

    public void setEarthworkServices(BigDecimal earthworkServices) {
        this.earthworkServices = earthworkServices;
    }

    public BigDecimal getAntiCorrosionService() {
        return antiCorrosionService;
    }

    public void setAntiCorrosionService(BigDecimal antiCorrosionService) {
        this.antiCorrosionService = antiCorrosionService;
    }

    public BigDecimal getLocalEarthwork() {
        return localEarthwork;
    }

    public void setLocalEarthwork(BigDecimal localEarthwork) {
        this.localEarthwork = localEarthwork;
    }

    public BigDecimal getMechanicServices() {
        return mechanicServices;
    }

    public void setMechanicServices(BigDecimal mechanicServices) {
        this.mechanicServices = mechanicServices;
    }

    public BigDecimal getProfessionalSubcontracting() {
        return professionalSubcontracting;
    }

    public void setProfessionalSubcontracting(BigDecimal professionalSubcontracting) {
        this.professionalSubcontracting = professionalSubcontracting;
    }

    public BigDecimal getOtherSubcontracting() {
        return otherSubcontracting;
    }

    public void setOtherSubcontracting(BigDecimal otherSubcontracting) {
        this.otherSubcontracting = otherSubcontracting;
    }

    public BigDecimal getAnticorrosionTeamCost() {
        return anticorrosionTeamCost;
    }

    public void setAnticorrosionTeamCost(BigDecimal anticorrosionTeamCost) {
        this.anticorrosionTeamCost = anticorrosionTeamCost;
    }

    public BigDecimal getMunicipalAdministration() {
        return municipalAdministration;
    }

    public void setMunicipalAdministration(BigDecimal municipalAdministration) {
        this.municipalAdministration = municipalAdministration;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getMarginalProfit() {
        return marginalProfit;
    }

    public void setMarginalProfit(BigDecimal marginalProfit) {
        this.marginalProfit = marginalProfit;
    }

    public BigDecimal getMarginalProfitRate() {
        return marginalProfitRate;
    }

    public void setMarginalProfitRate(BigDecimal marginalProfitRate) {
        this.marginalProfitRate = marginalProfitRate;
    }

    public String getSettlementPreparationAmount() {
        return settlementPreparationAmount;
    }

    public void setSettlementPreparationAmount(String settlementPreparationAmount) {
        this.settlementPreparationAmount = settlementPreparationAmount;
    }

    public String getNotReportedReview() {
        return notReportedReview;
    }

    public void setNotReportedReview(String notReportedReview) {
        this.notReportedReview = notReportedReview;
    }

    public String getReportConstructionUnit() {
        return reportConstructionUnit;
    }

    public void setReportConstructionUnit(String reportConstructionUnit) {
        this.reportConstructionUnit = reportConstructionUnit;
    }

    public String getReportBudgetDepartment() {
        return reportBudgetDepartment;
    }

    public void setReportBudgetDepartment(String reportBudgetDepartment) {
        this.reportBudgetDepartment = reportBudgetDepartment;
    }

    public String getReportAudit() {
        return reportAudit;
    }

    public void setReportAudit(String reportAudit) {
        this.reportAudit = reportAudit;
    }

    public String getPendingAccountAfterAudit() {
        return pendingAccountAfterAudit;
    }

    public void setPendingAccountAfterAudit(String pendingAccountAfterAudit) {
        this.pendingAccountAfterAudit = pendingAccountAfterAudit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPostAuditAmount() {
        return postAuditAmount;
    }

    public void setPostAuditAmount(String postAuditAmount) {
        this.postAuditAmount = postAuditAmount;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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

    public String getSubcontractSignDate() {
        return subcontractSignDate;
    }

    public void setSubcontractSignDate(String subcontractSignDate) {
        this.subcontractSignDate = subcontractSignDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getSubcontractContractMoney() {
        return subcontractContractMoney;
    }

    public void setSubcontractContractMoney(BigDecimal subcontractContractMoney) {
        this.subcontractContractMoney = subcontractContractMoney;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    public String getBmaterial() {
        return bmaterial;
    }

    public void setBmaterial(String bmaterial) {
        this.bmaterial = bmaterial;
    }

    public BigDecimal getMetalWorkshopCost() {
        return metalWorkshopCost;
    }

    public void setMetalWorkshopCost(BigDecimal metalWorkshopCost) {
        this.metalWorkshopCost = metalWorkshopCost;
    }

    public BigDecimal getAnsanAntiCorrosionAndPrefabrication() {
        return ansanAntiCorrosionAndPrefabrication;
    }

    public void setAnsanAntiCorrosionAndPrefabrication(BigDecimal ansanAntiCorrosionAndPrefabrication) {
        this.ansanAntiCorrosionAndPrefabrication = ansanAntiCorrosionAndPrefabrication;
    }

    public BigDecimal getCostAdjustment() {
        return costAdjustment;
    }

    public void setCostAdjustment(BigDecimal costAdjustment) {
        this.costAdjustment = costAdjustment;
    }

    public String getHrequipment() {
        return hrequipment;
    }

    public void setHrequipment(String hrequipment) {
        this.hrequipment = hrequipment;
    }

    public BigDecimal getApp() {
        return app;
    }

    public void setApp(BigDecimal app) {
        this.app = app;
    }

    public BigDecimal getAabss() {
        return aabss;
    }

    public void setAabss(BigDecimal aabss) {
        this.aabss = aabss;
    }

    public String getSaoss() {
        return saoss;
    }

    public void setSaoss(String saoss) {
        this.saoss = saoss;
    }

    public String getErpservicePurchaseOrderNumber() {
        return erpservicePurchaseOrderNumber;
    }

    public void setErpservicePurchaseOrderNumber(String erpservicePurchaseOrderNumber) {
        this.erpservicePurchaseOrderNumber = erpservicePurchaseOrderNumber;
    }

    public BigDecimal getAmaterialCost() {
        return amaterialCost;
    }

    public void setAmaterialCost(BigDecimal amaterialCost) {
        this.amaterialCost = amaterialCost;
    }

    public BigDecimal getBmaterialCost() {
        return bmaterialCost;
    }

    public void setBmaterialCost(BigDecimal bmaterialCost) {
        this.bmaterialCost = bmaterialCost;
    }

    Integer pid ;
    String   engineerName ;
    String        constructionUnit ;
    String       numOfItem ;
    BigDecimal investMoney ;
    String        workUnit ;
    String        isFin ;
    String       contractNum ;
    BigDecimal       contractMoney ;
    String       signDate ;
    String      contractStartDate ;
    String       contractEndDate ;
    BigDecimal       budgetMoney ;
    BigDecimal      laborCost ;
    BigDecimal      consumptionCost ;
    BigDecimal      mechanicsCost ;
    BigDecimal      takeCost ;
    String       workStartDate ;
    String      workEndDate ;
    String      planEndperiod ;
    String       engineerMainMessage  ;
    String       thisWeekCompleteProcess ;
    String       engineerTotalProcess ;
    String       restProcess ;
    String     nextWeekPlan ;
    BigDecimal      monthProduceVal ;
    BigDecimal     monthAMaterial ;
    BigDecimal        monthAdBeforeIncome ;
    BigDecimal      monthAdBehindIncome ;
    BigDecimal       yearProduceVal ;
    BigDecimal       yearAMaterial ;
    BigDecimal      yearAdBeforeIncome ;
    BigDecimal      yearAdBehindIncome ;
    BigDecimal       transpotCost ;
    BigDecimal      fuelCost ;
    BigDecimal     laborSubcontracting ;
    BigDecimal        earthworkServices ;
    BigDecimal      antiCorrosionService ;
    BigDecimal       localEarthwork ;
    BigDecimal       mechanicServices ;
    BigDecimal      professionalSubcontracting ;
    BigDecimal       otherSubcontracting ;
    BigDecimal       anticorrosionTeamCost ;
    BigDecimal      municipalAdministration ;
    BigDecimal      other ;
    BigDecimal       marginalProfit ;
    BigDecimal      marginalProfitRate ;
    String       settlementPreparationAmount ;
    String       notReportedReview ;
    String       reportConstructionUnit ;
    String      reportBudgetDepartment ;
    String      reportAudit ;
    String      pendingAccountAfterAudit ;
    String       account ;
    String      postAuditAmount ;
    String      invoiceAmount ;
    String     subcontractNo ;
    String     subcontractor ;
    String     subcontractContent ;
    String      subcontractingType ;
    String      subcontractSignDate ;
    String      startDate ;
    String     endDate ;
    BigDecimal      subcontractContractMoney ;
    String     performance ;
    String     costTotal ;
    String     bmaterial ;
    BigDecimal       metalWorkshopCost ;
    BigDecimal        ansanAntiCorrosionAndPrefabrication ;
    BigDecimal       costAdjustment ;
    String      hrequipment ;
    BigDecimal     app ;
    BigDecimal       aabss ;
    String     saoss ;
    String     erpservicePurchaseOrderNumber ;
    BigDecimal        amaterialCost ;
    BigDecimal       bmaterialCost ;
}
