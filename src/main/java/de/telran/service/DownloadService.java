package de.telran.service;

import de.telran.entity.DownloadedImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DownloadService {
    public List<DownloadedImage> downloadImages(List<String> imageUrls) {
        List<DownloadedImage> imageList = new ArrayList<>();
        for(String urlName:imageUrls) {
            try {
                URL url = new URL(urlName);
                BufferedImage image = ImageIO.read(url);
                imageList.add(new DownloadedImage(image, true));
            } catch (Exception ex) {
                System.err.println(urlName);
                System.err.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false));
            }
        }
        return imageList;
    }
}
