package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ItemProgress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemDao {
    Item getItemInfoFromReviewId(int review_id);

    void CreateItem(int team_id, String item_name, String item_describe);

    List<Item> findTeamAllItem(int team_id);

    ItemProgress findProgressById(int item_id);
}
