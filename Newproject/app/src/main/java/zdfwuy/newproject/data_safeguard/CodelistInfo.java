package zdfwuy.newproject.data_safeguard;

/**
 * Created by ASUS on 2021/5/9.
 */
public class CodelistInfo {

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getSqlSetence() {
        return sqlSetence;
    }

    public void setSqlSetence(String sqlSetence) {
        this.sqlSetence = sqlSetence;
    }

    public String getTopSelect() {
        return topSelect;
    }

    public void setTopSelect(String topSelect) {
        this.topSelect = topSelect;
    }

    public String getExportModel() {
        return exportModel;
    }

    public void setExportModel(String exportModel) {
        this.exportModel = exportModel;
    }

    Integer pid;
    String codeName;
    String sqlSetence;
    String topSelect;
    String exportModel;
}
