package de.telran.entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSuccessfull;

    public DownloadedImage(BufferedImage image, boolean status) {
        this.image = image;
        this.isSuccessfull = status;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }
}
