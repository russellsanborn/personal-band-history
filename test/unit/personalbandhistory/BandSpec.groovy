package personalbandhistory

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Band)
class BandSpec extends Specification {
    String newName
    String newBio
    LocalDate newStartDate
    LocalDate newEndDate
    
    def setup() {
        newName = "Test Band Name"
        newBio = "Test bio about the band"
        newStartDate = new LocalDate(2011, 1, 1)
        newEndDate = new LocalDate(2014, 1, 1)
    }

    def cleanup() {
    }

    @Unroll
    void "test #creates a band with name: '#name', bio: '#bio', location: '#location', startDate: '#startDate', endDate: '#endDate'"() {
        when:
            Band newBand = new Band(
                name: name, 
                bio: bio,
                location: location,
                startDate: startDate,
                endDate: endDate
            )
            newBand.save()
            Band createdBand = Band.findByName(name)
        then:
            if (creates == "creates") {
                assert createdBand
                createdBand.name == name
                createdBand.bio == bio
                createdBand.location = location
                createdBand.startDate = startDate
                createdBand.endDate = endDate
            }
            else {
                assert !createdBand
            }
        where:
            name        | bio        | location   | startDate                 | endDate                   ||  creates
            ""          | ""         | ""         | null                      | null                      || "does not create"
            ""          | "test bio" | ""         | null                      | null                      || "does not create"
            ""          | ""         | "test loc" | null                      | null                      || "does not create"
            ""          | ""         | ""         | new LocalDate(2011, 1, 1) | null                      || "does not create"
            ""          | ""         | ""         | null                      | new LocalDate(2014, 1, 1) || "does not create"
            "test name" | ""         | ""         | null                      | null                      || "creates"
            "test name" | "test bio" | "test loc" | new LocalDate(2011, 1, 1) | new LocalDate(2014, 1, 1) || "creates"
    }
}
