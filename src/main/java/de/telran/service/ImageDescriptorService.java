package de.telran.service;

import de.telran.entity.ImageDescriptor;

import java.util.List;
import java.util.stream.Collectors;

public class ImageDescriptorService {

    private static final String CSV_SEPARATOR = ";";

    private FileService fileService;

    public ImageDescriptorService(FileService fileService) {
        this.fileService = fileService;
    }

    public List<ImageDescriptor> getImageDescriptors(String fileName) {
        return fileService.loadStringsFromFile(fileName).stream()
                .map(s -> stringToImageDescriptor(s))
                .collect(Collectors.toList());
    }

    private static ImageDescriptor stringToImageDescriptor(String string) {
        String[] split = string.split(CSV_SEPARATOR);
        return new ImageDescriptor(split[0], split[1]);
    }


}
