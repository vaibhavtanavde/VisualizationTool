package test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.OSS;


public class OSSTest {
	public OSS shoppingSystem;

    @BeforeClass
    public void setUp() {
        shoppingSystem = new OSS();
    }

    @Test
    public void testLoginSuccess() {
        boolean result = shoppingSystem.login("username", "password");
        Assert.assertTrue(result, "Login should succeed");
    }
    

}
