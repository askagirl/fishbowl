package com.github.stefanbirkner.fishbowl;

import com.google.common.truth.Truth;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.github.stefanbirkner.fishbowl.Fishbowl.exceptionThrownBy;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Test the examples of the readme.
 */
public class FishbowlJUnitReadmeTest {
    @Test
    public void testJUnit() throws Exception {
        String noString = null;
        Throwable exception = exceptionThrownBy(() -> noString.trim());
        assertEquals(NullPointerException.class, exception.getClass());
    }

    @Test
    public void testHamcrest() {
        String noString = null;
        Throwable exception = exceptionThrownBy(() -> noString.trim());
        MatcherAssert.assertThat(exception, is(instanceOf(NullPointerException.class)));
    }

    @Test
    public void testAssertJ() {
        String noString = null;
        Throwable exception = exceptionThrownBy(() -> noString.trim());
        org.assertj.core.api.Assertions.assertThat(exception).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testFest() {
        String noString = null;
        Throwable exception = exceptionThrownBy(() -> noString.trim());
        org.fest.assertions.Assertions.assertThat(exception).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testTruth() {
        String noString = null;
        Throwable exception = exceptionThrownBy(() -> noString.trim());
        Truth.assertThat(exception).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void expectExceptionOfACertainType() {
        FooException exception = exceptionThrownBy(
            () -> { throw new FooException(3); }, FooException.class);
        assertEquals(3, exception.getValue());
    }
}
