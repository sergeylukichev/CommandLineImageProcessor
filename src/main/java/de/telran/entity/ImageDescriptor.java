package de.telran.entity;

public class ImageDescriptor {
    private String imageUrlName;
    private String actionName;

    public ImageDescriptor(String imageUrlName, String actionName) {
        this.imageUrlName = imageUrlName;
        this.actionName = actionName;
    }

    public String getImageUrlName() {
        return imageUrlName;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return "ImageDescriptor{" +
                "imageUrlName='" + imageUrlName + '\'' +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}
