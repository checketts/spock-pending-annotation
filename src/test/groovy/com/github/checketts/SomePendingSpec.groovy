package com.github.checketts

import com.github.checketts.annotations.Pending
import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by clintchecketts on 6/23/14.
 */
class SomePendingSpec extends Specification{

    @Ignore
    def "Test is ignored and marked as such"() {
        when:
        def a = 1 + 2
        then:
        a == 4
    }

    def "Test passes as normal"() {
        when:
        def a = 1 + 2
        then:
        a == 3
    }

    @Pending
    def "Failing due to bad assertion, should appear as Ignored/Skipped test due to annotation"() {
        when:
        def a = 1 + 2
        then:
        a == 4
    }

    @Pending("")
    def "Test passes, but due to pending annotation this fails"() {
        //Failure indicates that the annotation should be removed
        when:
        def a = 1 + 2
        then:
        a == 3
    }

}

