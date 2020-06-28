package de.telran.entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSuccessfull;
    private ImageDescriptor imageDescriptor;

    public DownloadedImage(BufferedImage image, boolean status, ImageDescriptor imageDescriptor) {
        this.image = image;
        this.isSuccessfull = status;
        this.imageDescriptor = imageDescriptor;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public ImageDescriptor getImageDescriptor() {
        return imageDescriptor;
    }
}
