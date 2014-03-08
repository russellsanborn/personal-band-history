package personalbandhistory

class ConcertService {

    Concert createConcert (CreateConcertCommand cmd) {
        new Concert(
            eventDate: cmd.eventDate,
            title: cmd.title,
            venueName: cmd.venueName,
            location: cmd.location
        ).save()
    }
}
