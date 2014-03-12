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
                assert Member.count() == 1
                assert createdMember.name == name
                assert createdMember.instrument == instrument
                assert createdMember.startDate == startDate
                assert createdMember.endDate == endDate
            }
            else {
                assert !createdMember
                assert Member.count() == 0
            }
        where:
            name        | instrument  | startDate                 | endDate                   ||  creates
            null        | null        | null                      | null                      || "does not create"
            null        | "test inst" | null                      | null                      || "does not create"
            null        | null        | new LocalDate(2011, 1, 1) | null                      || "does not create"
            null        | null        | null                      | new LocalDate(2014, 1, 1) || "does not create"
            "test name" | null        | null                      | null                      || "creates"
            "test name" | "test inst" | new LocalDate(2011, 1, 1) | new LocalDate(2014, 1, 1) || "creates"
    }

    @Unroll
    void "with start date: '#startDate', end date: '#endDate', getDateRange() should return '#expectedDateRange'" () {
        when:
            Member newMember = new Member(
                name: "test name",
                startDate: startDate,
                endDate: endDate
            )
            newMember.save()
            
        then:
            assert newMember.getDateRange() == expectedMemberDate
        
        where:
            startDate                   | endDate                   || expectedMemberDate
            null                        | null                      || "???? - ????"
            new LocalDate(2011, 1, 1)   | null                      || "2011 - ????"
            null                        | new LocalDate(2011, 1, 1) || "???? - 2011"
            new LocalDate(1995, 2, 2)   | new LocalDate(2011, 1, 1) || "1995 - 2011"
    }
    
}
