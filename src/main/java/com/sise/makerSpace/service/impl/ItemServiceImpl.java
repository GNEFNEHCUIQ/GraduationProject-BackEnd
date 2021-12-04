package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.ItemDao;
import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ItemProgress;
import com.sise.makerSpace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public Item getItemInfoFromReviewId(int review_id) {
        return itemDao.getItemInfoFromReviewId(review_id);
    }

    @Override
    public void CreateItem(int team_id, String item_name, String item_describe) {
        itemDao.CreateItem(team_id,item_name,item_describe);
    }

    @Override
    public List<Item> findTeamAllItem(int team_id) {
        return itemDao.findTeamAllItem(team_id);
    }

    @Override
    public ItemProgress findProgressById(int item_id) {
        return itemDao.findProgressById(item_id);
    }
}
