package de.telran.factory;

import de.telran.action.*;

public class ImageActionFactory {

    public ImageAction getImageAction(String actionName) {
        switch(actionName) {
            case "GRAYSCALE": return new GrayscaleImageAction();
            case "THUMBNAIL": return new ThumbnailImageAction();
            case "PREVIEW": return new PreviewImageAction();
            default: return new DefaultImageAction();
        }
    }
}
