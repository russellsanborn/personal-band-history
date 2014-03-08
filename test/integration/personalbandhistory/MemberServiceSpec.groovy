package personalbandhistory

import spock.lang.*
import org.joda.time.LocalDate

/**
 *
 */
class MemberServiceSpec extends Specification {
    MemberService memberService
    
    def setup() {
    }

    def cleanup() {
    }

    void "test an member can be created"() {
        when:
            String newName = "test name"
            String newInstrument = "test instrument"
            LocalDate newStartDate = new LocalDate(2011, 1, 1)
            LocalDate newEndDate = new LocalDate(2014, 1, 1)
        
            CreateMemberCommand newCreateMemberCommand = new CreateMemberCommand (
                name: newName,
                instrument: newInstrument,
                startDate: newStartDate,
                endDate: newEndDate
            )
            
            Member createdMember = memberService.createMember(newCreateMemberCommand)

        then:
            Member.count() == 1
            createdMember.name == newName
            createdMember.instrument == newInstrument
            createdMember.startDate == newStartDate
            createdMember.endDate == newEndDate
    }
}
