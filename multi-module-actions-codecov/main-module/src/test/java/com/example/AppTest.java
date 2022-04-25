package com.example;

import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Pojo pojo = new Pojo("oi","last");
        assertThat(pojo).isNotNull();
    }
}
