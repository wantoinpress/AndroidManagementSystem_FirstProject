package zdfwuy.newproject.data_safeguard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2021/5/9.
 */
public class ManagePeopleArray {
    String workUnit;
    List<ManagepeopleInfo> infoList = new ArrayList<>();

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public List<ManagepeopleInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<ManagepeopleInfo> infoList) {
        this.infoList = infoList;
    }
}
