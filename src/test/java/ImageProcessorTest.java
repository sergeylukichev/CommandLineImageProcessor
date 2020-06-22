import de.telran.ImageProcessor;
import de.telran.entity.ImageDescriptor;
import de.telran.service.ImageDescriptorService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImageProcessorTest {

    ImageDescriptorService imageDescriptorService = mock(ImageDescriptorService.class);

//    @Test
//    public void testDoProcessing() {
//        //configure mock
//        when(imageDescriptorService.getImageDescriptors(any())).thenReturn(createTestImageDescriptors());
//
//        //execute test method
//        ImageProcessor processor = new ImageProcessor(imageDescriptorService);
//        processor.doProcessing("test.txt");
//
//        //verify
//        verify(imageDescriptorService, times(1)).getImageDescriptors("test.txt");
//    }

    private static List<ImageDescriptor> createTestImageDescriptors() {
        return Arrays.asList(
                new ImageDescriptor("abc", "PREVIEW"),
                new ImageDescriptor("defiklm", "THUMBNAIL"));
    }
}
