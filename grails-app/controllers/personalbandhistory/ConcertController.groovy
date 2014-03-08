package personalbandhistory

import org.joda.time.LocalDate

class ConcertController {

}

class CreateConcertCommand {
    LocalDate eventDate
    String title
    String venueName
    String location
}