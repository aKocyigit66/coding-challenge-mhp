package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto;

import java.util.ArrayList;

public class ImageBlock extends ArticleBlock {

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public ArticleBlockDto map() {
        ImageBlockDto imageBlockDto = new ImageBlockDto();
        imageBlockDto.setSortIndex(this.getSortIndex());
        if(this.getImage() != null){
            imageBlockDto.setImage(this.getImage().map());
        }
        return imageBlockDto;
    }
    }

