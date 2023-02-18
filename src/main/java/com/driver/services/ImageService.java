package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image  = new Image();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimensions(dimensions);

        blog.getImageList().add(image);
        return image;
    }

    public void deleteImage(Image image){
       //delete image
        imageRepository2.delete(image);
    }

    public Image findById(int id) {
      return imageRepository2.findById(id).get();
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
