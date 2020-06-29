package de.telran.entity;

import java.awt.image.BufferedImage;

public class ActionableImage {
    private BufferedImage image;
    private boolean isSuccessfull;
    private String sourceUrl;
    private String actionName;

    public ActionableImage(BufferedImage image, boolean status, String sourceUrl, String actionName) {
        this.image = image;
        this.isSuccessfull = status;
        this.sourceUrl = sourceUrl;
        this.actionName = actionName;

    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getActionName() {
        return actionName;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
