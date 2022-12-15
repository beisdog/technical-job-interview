/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.cda.evenno;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EvenNumbersTest {


    @Test
    public void test1() {
        List<Integer> input1 = List.of(
                4, 7, 38, 99, 1024
        );
        List<Integer> expected = List.of(
                4, 38, 1024
        );

        List<Integer> result = EvenNumbers.getEvenNumbers(input1);
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
