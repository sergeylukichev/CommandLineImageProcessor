package de.telran.action;

import java.awt.image.BufferedImage;

public class ThumbnailImageAction implements ImageAction {
    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a thumbnail");
        return source;
    }
}
