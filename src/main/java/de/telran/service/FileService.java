package de.telran.service;

import de.telran.entity.ActionableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

    public List<String> loadStringsFromFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    public void saveImageAsFile(ActionableImage image) {

        try {
            ImageIO.write(image.getImage(), "jpg",new File("/Users/slukichev/Downloads/images/img_"+image.hashCode()+".jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg -> s3-eu-west-1.amazonaws.com.lukaroundimg.beelitz2017.1a.jpg
}
