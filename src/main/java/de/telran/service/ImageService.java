package de.telran.service;

import de.telran.action.ImageAction;
import de.telran.entity.ActionableImage;
import de.telran.factory.ImageActionFactory;

import java.awt.image.BufferedImage;

public class ImageService {

    private ImageActionFactory imageActionFactory;

    public ImageService(ImageActionFactory imageActionFactory) {
        this.imageActionFactory = imageActionFactory;
    }

    public ActionableImage processImage(ActionableImage image) {
        ImageAction imageAction = imageActionFactory.getImageAction(image.getActionName());
        try {
            image.setImage(imageAction.doAction(image.getImage()));//better use copying constructor
        } catch (Exception ex) {
            System.out.println("Could not process image with action "+image.getActionName()+": "+ex.getMessage());
        }
        return image;
    }
}
