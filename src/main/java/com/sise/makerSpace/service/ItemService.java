package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Item;

public interface ItemService {
    Item getItemInfoFromReviewId(int review_id);

    void CreateItem(int team_id,String item_name,String item_describe);
}
