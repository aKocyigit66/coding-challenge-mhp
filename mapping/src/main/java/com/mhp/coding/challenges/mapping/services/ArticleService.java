package com.mhp.coding.challenges.mapping.services;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ArticleDto> list() {
        final List<Article> articles = repository.all();
        ArrayList<ArticleDto> articleDtoList = new ArrayList<ArticleDto>();
        for(Article article : articles){
            articleDtoList.add(mapper.map(article));
        }
        return articleDtoList;
    }
    public ArticleDto articleForId(Long id) {
        final Article article = repository.findBy(id);
        if(article.getId() != null){
            return mapper.map(article);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Searched Article could not be found"
            );
        }
    }

    public ArticleDto create(ArticleDto articleDto) {
        final Article create = mapper.map(articleDto);
        repository.create(create);
        return mapper.map(create);
    }
}