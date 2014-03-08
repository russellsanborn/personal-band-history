package personalbandhistory

import spock.lang.*
import org.joda.time.LocalDate

/**
 *
 */
class ConcertServiceSpec extends Specification {
    ConcertService concertService
    
    def setup() {
    }

    def cleanup() {
    }

    void "test an concert can be created"() {
        when:
            String newTitle = "test title"
            String newVenueName = "test venue name"
            String newLocation = "test location"
            LocalDate newEventDate = new LocalDate(2011, 1, 1)
        
            CreateConcertCommand newCreateConcertCommand = new CreateConcertCommand (
                title: newTitle,
                venueName: newVenueName,
                location: newLocation,
                eventDate: newEventDate
            )
            
            Concert createdConcert = concertService.createConcert(newCreateConcertCommand)

        then:
            Concert.count() == 1
            createdConcert.title == newTitle
            createdConcert.venueName == newVenueName
            createdConcert.location == newLocation
            createdConcert.eventDate == newEventDate
    }
}
