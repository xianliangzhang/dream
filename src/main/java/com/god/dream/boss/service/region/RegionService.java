package com.god.dream.boss.service.region;

import com.god.dream.boss.dao.region.RegionDao;
import com.god.dream.boss.model.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/23.
 */
@Service
public class RegionService {

    @Autowired
    private RegionDao regionDao;

    @Transactional
    public Region find(Long regionId) {
        return regionDao.find(regionId);
    }


}
