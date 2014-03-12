package personalbandhistory

import org.joda.time.LocalDate

class MemberController {
    
    def list() {
        [members: Member.listOrderByName()]
    }
    
    def show(Long id) {
        Member member = Member.get(id)

        if (!member) {
            redirect uri: '/'
        }

        [member: member]
    }

}

class CreateMemberCommand {
    String instrument
    String name
    LocalDate startDate
    LocalDate endDate
}