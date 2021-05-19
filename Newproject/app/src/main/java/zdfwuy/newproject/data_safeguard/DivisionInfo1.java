package zdfwuy.newproject.data_safeguard;

/**
 * Created by ASUS on 2021/5/9.
 */
public class DivisionInfo1 {
    public String getInternalParameters() {
        return internalParameters;
    }

    public void setInternalParameters(String internalParameters) {
        this.internalParameters = internalParameters;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    Integer pid;


    String unitName;

    String remarks;

    String  internalParameters;
}
