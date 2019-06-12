package com.darren.factories;

import com.darren.domain.Teller;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TellerFactoryTest extends TestCase {

    public void testBuildTeller() {
    }

    private String TellerTest;

    @Before
    public void setUp() throws Exception {
        this.TellerTest = "TellerTest";
    }

    @Test
    public void buildTeller() {
        Teller admin = TellerFactory.buildTeller("123", "TellerUser", "Password123");
        System.out.println(admin);
        Assert.assertNotNull(admin.getTellerId());
    }
}