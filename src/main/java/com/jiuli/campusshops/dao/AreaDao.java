package com.jiuli.campusshops.dao;

import com.jiuli.campusshops.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();
}
