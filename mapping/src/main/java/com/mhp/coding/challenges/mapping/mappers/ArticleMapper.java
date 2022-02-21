package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ArticleMapper {
    public ArticleDto map(Article article){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setAuthor(article.getAuthor());
        articleDto.setDescription(article.getDescription());
        articleDto.setTitle(article.getTitle());
        ArrayList<ArticleBlockDto> articleBlockDtoArrayList =  new ArrayList<ArticleBlockDto>();
        Comparator<ArticleBlockDto> sorterArticleBlockDto = (o1,o2) -> o1.getSortIndex() - o2.getSortIndex();
        for (ArticleBlock blockEntry : article.getBlocks()){
            articleBlockDtoArrayList.add(blockEntry.map());
        }
        articleBlockDtoArrayList.sort(sorterArticleBlockDto);
        articleDto.setBlocks(articleBlockDtoArrayList);

        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }

}