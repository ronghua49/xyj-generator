import com.xyjsoft.generator.generator.utils.ZipUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author haohua
 * @version 1.0
 * @describe
 * @date 2020/1/10 13:45
 */
public class A {


    @Test
    public void test() throws IOException {


        String folder=System.getProperty("java.io.tmpdir");
        FileOutputStream outputStream = new FileOutputStream(new File(folder,"132.zip"));
        ZipUtils.toZip("C:\\xyjsoft",outputStream,true);

    }
}
