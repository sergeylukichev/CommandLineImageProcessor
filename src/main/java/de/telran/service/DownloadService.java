package de.telran.service;

import de.telran.entity.DownloadedImage;
import de.telran.entity.ImageDescriptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DownloadService {
    public List<DownloadedImage> downloadImages(List<ImageDescriptor> imageDescriptors) {
        List<DownloadedImage> imageList = new ArrayList<>();
        for(ImageDescriptor descriptor:imageDescriptors) {
            try {
                URL url = new URL(descriptor.getImageUrlName());
                BufferedImage image = ImageIO.read(url);
                imageList.add(new DownloadedImage(image, true, descriptor));
            } catch (Exception ex) {
                System.err.println(descriptor.getImageUrlName());
                System.err.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false, descriptor));
            }
        }
        return imageList;
    }
}
