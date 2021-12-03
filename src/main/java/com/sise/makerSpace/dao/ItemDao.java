package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemDao {
    Item getItemInfoFromReviewId(int review_id);

    void CreateItem(int team_id, String item_name, String item_describe);
}
