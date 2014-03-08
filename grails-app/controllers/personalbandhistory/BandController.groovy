package personalbandhistory

import org.joda.time.LocalDate

class BandController {

}

class CreateBandCommand {
    String bio
    String name
    String location
    LocalDate startDate
    LocalDate endDate
}
