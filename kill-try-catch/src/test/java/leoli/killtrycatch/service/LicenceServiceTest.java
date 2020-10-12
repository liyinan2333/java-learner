package leoli.killtrycatch.service;

import junit.framework.TestCase;
import leoli.killtrycatch.bean.Licence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 演示
 *
 * @author leoli
 * @date 2020/10/12
 */
@RunWith(Parameterized.class)
public class LicenceServiceTest extends TestCase {

    @Parameterized.Parameter
    public Licence licence;

    @Parameterized.Parameters
    public static Collection<Object> params() {
        return Arrays.asList(new Object[]{new Licence(), null});
    }


    @Test
    public void assertTest() {
        new LicenceService().checkNotNull(licence);
    }

}