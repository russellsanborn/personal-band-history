package personalbandhistory

import spock.lang.*
import org.joda.time.LocalDate

/**
 *
 */
class BandServiceSpec extends Specification {
    BandService bandService
    
    def setup() {
    }

    def cleanup() {
    }

    void "test an band can be created"() {
        when:
            String newName = "test band name"
            String newBio = "test bio"
            String newLocation = "test location"
            LocalDate newStartDate = new LocalDate(2011, 1, 1)
            LocalDate newEndDate = new LocalDate(2014, 1, 1)
        
            CreateBandCommand newCreateBandCommand = new CreateBandCommand (
                name: newName,
                bio: newBio,
                location: newLocation,
                startDate: newStartDate,
                endDate: newEndDate
            )
            
            Band createdBand = bandService.createBand(newCreateBandCommand)

        then:
            Band.count() == 1
            createdBand.name == newName
            createdBand.bio == newBio
            createdBand.location == newLocation
            createdBand.startDate == newStartDate
            createdBand.endDate == newEndDate
    }

    void "test an albium can be added to an band"() {
        when:
            String newAlbumName1 = "test album 1"
            String newAlbumName2 = "test album 2"
        
            CreateBandCommand newCreateBandCommand = new CreateBandCommand (
                name: "test band name",
                bio: "test bio",
                location: "test location",
                startDate: new LocalDate(2011, 1, 1),
                endDate: new LocalDate(2014, 1, 1)
            )
            
            Band createdBand = bandService.createBand(newCreateBandCommand)
            
            bandService.addAlbum(createdBand, newAlbumName1, new LocalDate(2011, 1, 1))
            bandService.addAlbum(createdBand, newAlbumName2, new LocalDate(2011, 1, 1))
        then:
            assert createdBand.albums.size() == 2
            assert Album.findByName(newAlbumName1)
            assert Album.findByName(newAlbumName2)
    }
    
    void "test a member can be added to an band"() {
        when:
            String newMemberName1 = "test member 1"
            String newMemberName2 = "test member 2"
        
            CreateBandCommand newCreateBandCommand = new CreateBandCommand (
                name: "test band name",
                bio: "test bio",
                location: "test location",
                startDate: new LocalDate(2011, 1, 1),
                endDate: new LocalDate(2014, 1, 1)
            )
            
            Band createdBand = bandService.createBand(newCreateBandCommand)
            
            bandService.addMember(createdBand, newMemberName1, "test instrument", new LocalDate(2011, 1, 1), new LocalDate(2014, 1, 1))
            bandService.addMember(createdBand, newMemberName2, "test instrument", new LocalDate(2011, 1, 1), new LocalDate(2014, 1, 1))
        then:
            assert createdBand.members.size() == 2
            assert Member.findByName(newMemberName1)
            assert Member.findByName(newMemberName2)
    }
}
