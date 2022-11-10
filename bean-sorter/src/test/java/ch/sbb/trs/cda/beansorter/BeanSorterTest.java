/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.cda.beansorter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeanSorterTest {

    List<Customer> customers = List
            .of(
                    new Customer("Kevin", "Leopold"),
                    new Customer("David", "Beisert"),
                    new Customer("David", "Oetiker"),
                    new Customer("David", "Wagner"),
                    new Customer("Markus", "Reith"),
                    new Customer("Jaime", "Freire"),
                    new Customer("Michael", "Sunnard")
            );
    List<Customer> sortedByLastNameAsc = List
            .of(
                    new Customer("David", "Beisert"),
                    new Customer("Jaime", "Freire"),
                    new Customer("Kevin", "Leopold"),
                    new Customer("David", "Oetiker"),
                    new Customer("Markus", "Reith"),
                    new Customer("Michael", "Sunnard"),
                    new Customer("David", "Wagner")
            );

    List<Customer> sortedByLastNameDesc = List
            .of(
                    new Customer("David", "Wagner"),
                    new Customer("Michael", "Sunnard"),
                    new Customer("Markus", "Reith"),
                    new Customer("David", "Oetiker"),
                    new Customer("Kevin", "Leopold"),
                    new Customer("Jaime", "Freire"),
                    new Customer("David", "Beisert")
            );


    List<Customer> sortedByFirstNameAsc = List
            .of(
                    new Customer("David", "Beisert"),
                    new Customer("David", "Oetiker"),
                    new Customer("David", "Wagner"),
                    new Customer("Jaime", "Freire"),
                    new Customer("Kevin", "Leopold"),
                    new Customer("Markus", "Reith"),
                    new Customer("Michael", "Sunnard")
            );


    static void checkList(List<Customer> unsorted, String property, boolean asc, List<Customer> sortedByProperty) {
        List<Customer> sorted = BeanSorter.sortByField(unsorted, property, asc);
        System.out.printf("Sorted by '" + property + "' " + (asc ? "ascending" : "descending") + ": " + sorted);
        assertThat(sorted).isEqualTo(sortedByProperty);
    }

    @Test
    void sortByFieldLastName() {
        checkList(customers, "lastName", true, sortedByLastNameAsc);
    }

    @Test
    void sortByFieldLastNameDesc() {
        checkList(customers, "lastName", false, sortedByLastNameDesc);
    }
    @Test
    void sortByFieldFirstName() {
        checkList(customers, "firstName", true, sortedByFirstNameAsc);
    }
}
