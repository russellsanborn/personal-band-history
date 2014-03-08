package personalbandhistory

import org.joda.time.LocalDate

class MemberController {


}

class CreateMemberCommand {
    String instrument
    String name
    LocalDate startDate
    LocalDate endDate
}