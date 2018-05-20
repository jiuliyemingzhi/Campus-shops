package com.jiuli.campusshops.service.impl;

import com.jiuli.campusshops.dao.AreaDao;
import com.jiuli.campusshops.entity.Area;
import com.jiuli.campusshops.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
