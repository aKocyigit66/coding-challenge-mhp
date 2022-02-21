package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class ArticleBlock implements ArticleBlockInterface{

    private int sortIndex;

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }


    @Override
    public ArticleBlockDto map() {
        ArticleBlockDto articleBlockDto = new ArticleBlockDto();
        articleBlockDto.setSortIndex(this.getSortIndex());
        return articleBlockDto;
    }
}
