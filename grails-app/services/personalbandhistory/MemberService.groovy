package personalbandhistory

class MemberService {

    Member createMember (CreateMemberCommand cmd) {
        new Member(
            instrument: cmd.instrument,
            name: cmd.name,
            startDate: cmd.startDate,
            endDate: cmd.endDate
        ).save()
    }
}
