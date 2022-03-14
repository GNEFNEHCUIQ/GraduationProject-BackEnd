package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ItemProgress;

import java.util.List;

public interface ItemService {
    Item getItemInfoFromReviewId(int review_id);

    void CreateItem(int team_id,String item_name,String item_describe);

    List<Item> findTeamAllItem(int team_id);

    ItemProgress findProgressById(int item_id);

    List<Item> getYourItem(int user_id);

    void createDemand(ItemProgress itemProgress);

    List<ItemProgress> getItemProgress(int item_id);

    void checkProgress(int progress_id);

    void deleteProgress(int progress_id);

    ItemProgress getOneProgressById(int progress_id);

    void updateProgress(ItemProgress itemProgress);
}
