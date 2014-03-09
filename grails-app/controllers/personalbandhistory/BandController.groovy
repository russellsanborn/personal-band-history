package personalbandhistory

import org.joda.time.LocalDate

class BandController {
    
    def show(Long id) {
        Band band = Band.get(id)

        if (!band) {
            redirect uri: '/'
        }

        [band: band]
    }
}

class CreateBandCommand {
    String bio
    String name
    String location
    LocalDate startDate
    LocalDate endDate
}
