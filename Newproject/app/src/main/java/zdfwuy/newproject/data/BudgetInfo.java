package zdfwuy.newproject.data;


import java.math.BigDecimal;

public class BudgetInfo {

    Integer pid;
    
    
    String engineerName;

    
    String numOfItem;

    
    String constructionUnit;

    
    String workUnit;

    
    Integer engineerTime;
    
    
    BigDecimal budgetMoney;

    
    BigDecimal laborCost;

    
    BigDecimal AMaterialCost;

    
    BigDecimal BMaterialCost;

    
    BigDecimal consumptionCost;

    
    BigDecimal mechanicsCost;


    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public BigDecimal getAMaterialCost() {
        return AMaterialCost;
    }

    public void setAMaterialCost(BigDecimal AMaterialCost) {
        this.AMaterialCost = AMaterialCost;
    }

    public BigDecimal getBMaterialCost() {
        return BMaterialCost;
    }

    public void setBMaterialCost(BigDecimal BMaterialCost) {
        this.BMaterialCost = BMaterialCost;
    }

    public BigDecimal getBudgetMoney() {
        return budgetMoney;
    }

    public void setBudgetMoney(BigDecimal budgetMoney) {
        this.budgetMoney = budgetMoney;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public BigDecimal getConsumptionCost() {
        return consumptionCost;
    }

    public void setConsumptionCost(BigDecimal consumptionCost) {
        this.consumptionCost = consumptionCost;
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

    public BigDecimal getFinalBudget() {
        return finalBudget;
    }

    public void setFinalBudget(BigDecimal finalBudget) {
        this.finalBudget = finalBudget;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getMechanicsCost() {
        return mechanicsCost;
    }

    public void setMechanicsCost(BigDecimal mechanicsCost) {
        this.mechanicsCost = mechanicsCost;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getTakeCost() {
        return takeCost;
    }

    public void setTakeCost(BigDecimal takeCost) {
        this.takeCost = takeCost;
    }

    BigDecimal takeCost;

    
    BigDecimal finalBudget;

}
