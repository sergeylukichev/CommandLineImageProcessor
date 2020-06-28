package de.telran.service;

import de.telran.action.ImageAction;
import de.telran.factory.ImageActionFactory;

import java.awt.image.BufferedImage;

public class ImageService {

    private ImageActionFactory imageActionFactory;

    public ImageService(ImageActionFactory imageActionFactory) {
        this.imageActionFactory = imageActionFactory;
    }

    public BufferedImage processImage(BufferedImage image, String actionName) {
        ImageAction imageAction = imageActionFactory.getImageAction(actionName);
        try {
            return imageAction.doAction(image);
        } catch (Exception ex) {
            System.out.println("Could not process image with action "+actionName+": "+ex.getMessage());
        }
        return image;
    }
}
