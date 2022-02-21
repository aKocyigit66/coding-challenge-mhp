package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

import java.util.ArrayList;
import java.util.List;

public class GalleryBlock extends ArticleBlock {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public ArticleBlockDto map() {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto();
        galleryBlockDto.setSortIndex(this.getSortIndex());
        ArrayList<ImageDto> imageDtoArrayList = new ArrayList<>();
        for(Image tempImage : this.getImages()){
            if(tempImage != null){
                imageDtoArrayList.add(tempImage.map());
            }
        }
        galleryBlockDto.setImages(imageDtoArrayList);
        return galleryBlockDto;
    }
}
