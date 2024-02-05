package com.hs.ykh.containter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BigClass {

    private String name;

    private SmallClass smallClass;

    private String[] attrs;

    private List<SmallClass> smallClassList;

    private Map<String,SmallClass> stringSmallClassMap;

    public Map<String, SmallClass> getStringSmallClassMap() {
        return stringSmallClassMap;
    }

    public void setStringSmallClassMap(Map<String, SmallClass> stringSmallClassMap) {
        this.stringSmallClassMap = stringSmallClassMap;
    }

    public List<SmallClass> getSmallClassList() {
        return smallClassList;
    }

    public void setSmallClassList(List<SmallClass> smallClassList) {
        this.smallClassList = smallClassList;
    }

    public String[] getAttrs() {
        return attrs;
    }

    public void setAttrs(String[] attrs) {
        this.attrs = attrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SmallClass getSmallClass() {
        return smallClass;
    }

    public void setSmallClass(SmallClass smallClass) {
        this.smallClass = smallClass;
    }

    @Override
    public String toString() {
        return "BigClass{" +
                "name='" + name + '\'' +
                ", smallClass=" + smallClass +
                ", attrs=" + Arrays.toString(attrs) +
                ", smallClassList=" + smallClassList +
                ", stringSmallClassMap=" + stringSmallClassMap +
                '}';
    }
}
