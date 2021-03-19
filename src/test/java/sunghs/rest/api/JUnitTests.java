package sunghs.rest.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
public class JUnitTests {

    @BeforeAll
    public static void beforeAll() {
        log.info("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        log.info("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        log.info("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        log.info("afterAll");
    }

    @Test
    public void noArgsTest() {
        log.info("noArgsTest");
    }

    @ParameterizedTest
    @DisplayName("파라미터를 넣어 테스트")
    @ValueSource(ints = {
        1, 2, 3, 4, 5
    })
    public void argsTest(final Integer i) {
        Assertions.assertTrue(convert(i));
        Assertions.assertEquals(3, i);
    }

    // i 값이 5 미만이라면 true를 줍니다.
    private boolean convert(Integer i) {
        return i < 5;
    }

    @Test
    public void exceptionTest() {
        Assertions.assertThrows(NumberFormatException.class, this::exceptionGenerator);
    }

    private void exceptionGenerator() {
        throw new NumberFormatException();
    }
}
