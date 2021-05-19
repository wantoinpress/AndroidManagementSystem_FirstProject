package zdfwuy.newproject.data_safeguard;

/**
 * Created by ASUS on 2021/5/9.
 */
public class CodingStyleInfo {
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getColumnField() {
        return columnField;
    }

    public void setColumnField(String columnField) {
        this.columnField = columnField;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(String isSeen) {
        this.isSeen = isSeen;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

    public String getSelectCondition() {
        return selectCondition;
    }

    public void setSelectCondition(String selectCondition) {
        this.selectCondition = selectCondition;
    }

    public String getListSetences() {
        return listSetences;
    }

    public void setListSetences(String listSetences) {
        this.listSetences = listSetences;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    Integer pid ;
           String  columnField;
           String  columnTitle;
//            columnWidth
           String  alignment;
            String dataType;
            String isSeen;
            String isLock;
            String isEdit;
            String checkBox;
            String selectCondition;
//             conditionWidth
            String listSetences;
            String codeName;
}
