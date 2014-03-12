package personalbandhistory

import org.joda.time.LocalDate

class ConcertController {
    
    def list() {
        [concerts: Concert.listOrderByEventDate()]
    }
    
    def show(Long id) {
        Concert concert = Concert.get(id)

        if (!concert) {
            redirect uri: '/'
        }

        [concert: concert,
        bands: concert.bands.sort {it}]
    }
}

class CreateConcertCommand {
    LocalDate eventDate
    String title
    String venueName
    String location
}