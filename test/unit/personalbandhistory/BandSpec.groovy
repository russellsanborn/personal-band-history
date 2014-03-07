package personalbandhistory

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Band)
@Mock([Album, Member])
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
            Band createdBand = Band.first()
        then:
            if (creates == "creates") {
                assert createdBand
                Band.count() == 1
                createdBand.name == name
                createdBand.bio == bio
                createdBand.location == location
                createdBand.startDate == startDate
                createdBand.endDate == endDate
            }
            else {
                assert !createdBand
                Band.count() == 0
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
    
    @Unroll
    void "test when adding #albumCount albums to an band, the band conatins #expectedAlbums albums" () {
        when:
            Band newBand = new Band(
                name: "test name"
            )
            newBand.save()
           
            albumCount.times {
                Album newAlbum = new Album(
                    name: "test album name"
                ).save(validate:false)
            
                newBand.addToAlbums(newAlbum)
            }
        
        then:
            assert newBand.albums?.size() == expectedAlbums
        
        where:
           albumCount    || expectedAlbums
           1             || 1
           3             || 3 
    }

    @Unroll
    void "test when adding #memberCount members to an band, the band conatins #expectedMembers members" () {
        when:
            Band newBand = new Band(
                name: "test name"
            )
            newBand.save()
           
            memberCount.times {
                Member newMember = new Member(
                    name: "test member name"
                ).save(validate:false)
            
                newBand.addToMembers(newMember)
            }
        
        then:
            assert newBand.members?.size() == expectedMembers
        
        where:
           memberCount    || expectedMembers
           1              || 1
           3              || 3 
    }
}
