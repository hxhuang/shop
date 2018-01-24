package quick.framework.common.tests;

import org.junit.Test;
import quick.framework.common.upload.QiniuUpload;

import java.io.File;

public class UploadTokenTests {

    @Test
    public void testUploadToken() {
        File file = new File("E:/workspace/shop/apache-tomat-8.0.48/webapps/resources/images");

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
//                System.out.println(f.getName());
              System.out.println( QiniuUpload.uploadToFile(f,"images/icon/2018/01/24/"));

            }
        }

    }
}
