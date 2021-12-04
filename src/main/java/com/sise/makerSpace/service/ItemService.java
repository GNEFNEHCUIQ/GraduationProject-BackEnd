package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ItemProgress;

import java.util.List;

public interface ItemService {
    Item getItemInfoFromReviewId(int review_id);

    void CreateItem(int team_id,String item_name,String item_describe);

    List<Item> findTeamAllItem(int team_id);

    ItemProgress findProgressById(int item_id);
}
