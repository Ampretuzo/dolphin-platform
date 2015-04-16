package com.canoo.dolphin.server.proxy;

import com.canoo.dolphin.mapping.Property;

import java.util.List;

/**
 * Created by hendrikebbers on 15.04.15.
 */

public interface TestCarModel {

    Integer getYear();
    void setYear(Integer inYear);

    TestCarManufacturer getCarManufacturer();
    void setCarManufacturer(TestCarManufacturer manufacturer);

    public Property<String> getBrandNameProperty();

    List<Integer> getTripKilometerCounters();

}
