package com.jiuli.campusshops.service;

import com.jiuli.campusshops.BaseTest;
import com.jiuli.campusshops.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("fff", areaList.get(0).getName());
    }
}
