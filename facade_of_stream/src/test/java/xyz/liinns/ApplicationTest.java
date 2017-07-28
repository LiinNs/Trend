package xyz.liinns;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Description:
 * Created by LiinNs on 2017-7-28 0028.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @ClassRule
    public static OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        String output = ApplicationTest.outputCapture.toString();
        assertThat(output).contains("name='海口', zipCode='570100'");
    }

}