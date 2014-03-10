package personalbandhistory

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Concert)
class ConcertSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

@Unroll
    void "test #creates an concert with title: '#title', eventDate: '#eventDate', location: '#location', venueName: '#venueName'"() {
        when:
            Concert newConcert = new Concert(
                title: title, 
                eventDate: eventDate,
                location: location,
                venueName: venueName
            )
            newConcert.save()
            Concert createdConcert = Concert.first()
        then:
            if (creates == "creates") {
                assert createdConcert
                assert Concert.count() == 1
                assert createdConcert.title == title
                assert createdConcert.eventDate == eventDate
                assert createdConcert.location == location
                assert createdConcert.venueName == venueName
            }
            else {
                assert !createdConcert
                assert Concert.count() == 0
            }
        where:
            title        | eventDate                 | location   | venueName    ||  creates
            null         | null                      | null       | null         || "does not create"
            "test title" | null                      | null       | null         || "does not create"
            null         | new LocalDate(2011, 1, 1) | null       | null         || "creates"
            null         | null                      | "test loc" | null         || "does not create"
            null         | null                      | null       | "test venue" || "does not create"
            "test title" | new LocalDate(2011, 1, 1) | "test loc" | "test venue" || "creates"
    }

    @Unroll
    void "test when adding #bandCount bands to an concert, the concert conatins #expectedBands bands" () {
        when:
            Concert newConcert = new Concert(
                eventDate: new LocalDate(2011, 1, 1) 
            )
            newConcert.save()
           
            bandCount.times {
                String newBand = new String()
                newBand = "test band name" + it
            
                newConcert.addToBands(newBand)
            }
        
        then:
            assert newConcert.bands?.size() == expectedBands
        
        where:
           bandCount    || expectedBands
           1            || 1
           3            || 3
    }
}
