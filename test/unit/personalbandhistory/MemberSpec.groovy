package personalbandhistory

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Member)
class MemberSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test #creates a member with name: '#name', instrument: '#instrument', startDate: '#startDate', endDate: '#endDate'"() {
        when:
            Member newMember = new Member(
                name: name, 
                instrument: instrument,
                startDate: startDate,
                endDate: endDate
            )
            newMember.save()
            Member createdMember = Member.first()
        then:
            if (creates == "creates") {
                assert createdMember
                Member.count() == 1
                createdMember.name == name
                createdMember.instrument == instrument
                createdMember.startDate == startDate
                createdMember.endDate == endDate
            }
            else {
                assert !createdMember
                Member.count() == 0
            }
        where:
            name        | instrument  | startDate                 | endDate                   ||  creates
            ""          | ""          | null                      | null                      || "does not create"
            ""          | "test inst" | null                      | null                      || "does not create"
            ""          | ""          | new LocalDate(2011, 1, 1) | null                      || "does not create"
            ""          | ""          | null                      | new LocalDate(2014, 1, 1) || "does not create"
            "test name" | ""          | null                      | null                      || "creates"
            "test name" | "test inst" | new LocalDate(2011, 1, 1) | new LocalDate(2014, 1, 1) || "creates"
    }
}
