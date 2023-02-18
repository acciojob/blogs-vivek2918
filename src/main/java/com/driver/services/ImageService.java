package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int count = 0;
        Image image = imageRepository2.findById(id).get();

        String image_dime[] = image.getDimensions().split("X");
        int image_lenght = Integer.parseInt(image_dime[0]);
        int image_breath = Integer.parseInt(image_dime[1]);

        String screen_dime[] = screenDimensions.split("X");
        int screen_lenght = Integer.parseInt(screen_dime[0]);
        int screen_breath = Integer.parseInt(screen_dime[1]);

        count = (screen_lenght/image_lenght) * (screen_breath/image_breath);
        return count;
    }
}
