package zdfwuy.newproject.data;


import java.math.BigDecimal;

public class CostInfo {
  
    Integer pid;


    public BigDecimal getAnsanAntiCorrosionAndPrefabrication() {
        return AnsanAntiCorrosionAndPrefabrication;
    }

    public void setAnsanAntiCorrosionAndPrefabrication(BigDecimal ansanAntiCorrosionAndPrefabrication) {
        AnsanAntiCorrosionAndPrefabrication = ansanAntiCorrosionAndPrefabrication;
    }

    public BigDecimal getAntiCorrosionService() {
        return antiCorrosionService;
    }

    public void setAntiCorrosionService(BigDecimal antiCorrosionService) {
        this.antiCorrosionService = antiCorrosionService;
    }

    public BigDecimal getAnticorrosionTeamCost() {
        return anticorrosionTeamCost;
    }

    public void setAnticorrosionTeamCost(BigDecimal anticorrosionTeamCost) {
        this.anticorrosionTeamCost = anticorrosionTeamCost;
    }

    public String getBMaterial() {
        return BMaterial;
    }

    public void setBMaterial(String BMaterial) {
        this.BMaterial = BMaterial;
    }

    public BigDecimal getCostAdjustment() {
        return CostAdjustment;
    }

    public void setCostAdjustment(BigDecimal costAdjustment) {
        CostAdjustment = costAdjustment;
    }

    public String getCostTotal() {
        return CostTotal;
    }

    public void setCostTotal(String costTotal) {
        CostTotal = costTotal;
    }

    public BigDecimal getEarthworkServices() {
        return earthworkServices;
    }

    public void setEarthworkServices(BigDecimal earthworkServices) {
        this.earthworkServices = earthworkServices;
    }

    public BigDecimal getEngineerIncome() {
        return engineerIncome;
    }

    public void setEngineerIncome(BigDecimal engineerIncome) {
        this.engineerIncome = engineerIncome;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(String fillingDate) {
        this.fillingDate = fillingDate;
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

    public BigDecimal getLocalEarthwork() {
        return localEarthwork;
    }

    public void setLocalEarthwork(BigDecimal localEarthwork) {
        this.localEarthwork = localEarthwork;
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

    public BigDecimal getMechanicServices() {
        return mechanicServices;
    }

    public void setMechanicServices(BigDecimal mechanicServices) {
        this.mechanicServices = mechanicServices;
    }

    public BigDecimal getMetalWorkshopCost() {
        return MetalWorkshopCost;
    }

    public void setMetalWorkshopCost(BigDecimal metalWorkshopCost) {
        MetalWorkshopCost = metalWorkshopCost;
    }

    public BigDecimal getMunicipalAdministration() {
        return municipalAdministration;
    }

    public void setMunicipalAdministration(BigDecimal municipalAdministration) {
        this.municipalAdministration = municipalAdministration;
    }

    public String getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(String numOfItem) {
        this.numOfItem = numOfItem;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getOtherSubcontracting() {
        return otherSubcontracting;
    }

    public void setOtherSubcontracting(BigDecimal otherSubcontracting) {
        this.otherSubcontracting = otherSubcontracting;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public BigDecimal getProfessionalSubcontracting() {
        return professionalSubcontracting;
    }

    public void setProfessionalSubcontracting(BigDecimal professionalSubcontracting) {
        this.professionalSubcontracting = professionalSubcontracting;
    }

    public BigDecimal getTranspotCost() {
        return transpotCost;
    }

    public void setTranspotCost(BigDecimal transpotCost) {
        this.transpotCost = transpotCost;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    String engineerName;

    
    String numOfItem;

    
    String workUnit;

    
    BigDecimal engineerIncome;

    
    String CostTotal;

    
    String BMaterial;

    
    BigDecimal transpotCost;    //??????

    
    BigDecimal fuelCost;    //????????????

    
    BigDecimal laborSubcontracting;     //????????????

    
    BigDecimal earthworkServices;       //????????????

    
    BigDecimal antiCorrosionService;    //????????????

    
    BigDecimal localEarthwork;          //????????????

    
    BigDecimal mechanicServices;        //????????????

    
    BigDecimal professionalSubcontracting;//????????????

    
    BigDecimal otherSubcontracting;        //????????????

    
    BigDecimal anticorrosionTeamCost;       //???????????????

    
    BigDecimal MetalWorkshopCost;           //??????????????????

    
    BigDecimal AnsanAntiCorrosionAndPrefabrication; //?????????????????????

    
    BigDecimal municipalAdministration;           //??????

    
    BigDecimal other;

    
    BigDecimal CostAdjustment;

    
    BigDecimal marginalProfit;           //????????????

    
    BigDecimal marginalProfitRate;

    
    String fillingDate;

}
