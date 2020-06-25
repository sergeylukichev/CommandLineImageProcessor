package de.telran.action;

import java.awt.image.BufferedImage;

public interface ImageAction {
    BufferedImage doAction(BufferedImage source) throws Exception;
}
