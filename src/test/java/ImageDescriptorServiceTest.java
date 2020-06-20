import de.telran.entity.ImageDescriptor;
import de.telran.service.FileService;
import de.telran.service.ImageDescriptorService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ImageDescriptorServiceTest {

    //mock creation
    FileService fileService = mock(FileService.class);

    @Test
    public void testGetEmptyImageDescriptors() {
        //configure mocks
        when(fileService.loadStringsFromFile("testfile.txt")).thenReturn(Collections.emptyList());

        //execute testing code

        ImageDescriptorService service = new ImageDescriptorService(fileService);
        List<ImageDescriptor> imageDescriptors = service.getImageDescriptors("testfile.txt");

        //assert results
        assertTrue(imageDescriptors.isEmpty());

        verify(fileService, times(1)).loadStringsFromFile("testfile.txt");

    }

    @Test
    public void testGetImageDescriptors() {
        //configure mocks
        when(fileService.loadStringsFromFile("testfile.txt")).thenReturn(createTestString());

        //execute testing code

        ImageDescriptorService service = new ImageDescriptorService(fileService);
        List<ImageDescriptor> imageDescriptors = service.getImageDescriptors("testfile.txt");

        //assert results
        System.out.println(imageDescriptors);
        assertEquals(2, imageDescriptors.size());
        assertEquals("abc", imageDescriptors.get(0).getImageUrlName());
        assertEquals("PREVIEW", imageDescriptors.get(0).getActionName());

    }

    private static List<String> createTestString() {
        return Arrays.asList("abc;PREVIEW", "defiklm;THUMBNAIL");
    }

    private static List<ImageDescriptor> createTestImageDescriptors() {
        return Arrays.asList(
                new ImageDescriptor("abc", "PREVIEW"),
                new ImageDescriptor("defiklm", "THUMBNAIL"));
    }
}
