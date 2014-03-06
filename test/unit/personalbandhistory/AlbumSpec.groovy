package personalbandhistory

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Album)
@Mock([Song, Member])
class AlbumSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test #creates an album with name: '#name', releaseDate: '#releaseDate'"() {
        when:
            Album newAlbum= new Album(
                name: name, 
                releaseDate: releaseDate
            )
            newAlbum.save()
            Album createdAlbum = Album.findByName(name)
        then:
            if (creates == "creates") {
                assert createdAlbum
                createdAlbum.name == name
                createdAlbum.releaseDate = releaseDate
            }
            else {
                assert !createdAlbum
            }
        where:
            name        | releaseDate               ||  creates
            ""          | null                      || "does not create"
            ""          | new LocalDate(2011, 1, 1) || "does not create"
            "test name" | null                      || "creates"
            "test name" | new LocalDate(2011, 1, 1) || "creates"
    }
    
    @Unroll
    void "test when adding #songCount songs to an album, the album conatins #expectedSongs songs" () {
        when:
            Album newAlbum= new Album(
                name: "test name", 
            )
            newAlbum.save()
           
            songCount.times {
                Song newSong = new Song(
                    name: "test song name"
                ).save(validate:false)
            
                newAlbum.addToSongs(newSong)
            }
        
        then:
            assert newAlbum.songs?.size() == expectedSongs
        
        where:
           songCount    || expectedSongs
           1            || 1
           3            || 3
    }
    
    @Unroll
    void "test when adding #memberCount members to an album, the album conatins #expectedMembers members" () {
        when:
            Album newAlbum= new Album(
                name: "test name", 
            )
            newAlbum.save()
           
            memberCount.times {
                Member newMember = new Member(
                    name: "test member name"
                ).save(validate:false)
            
                newAlbum.addToMembers(newMember)
            }
        
        then:
            assert newAlbum.members?.size() == expectedMembers
        
        where:
           memberCount    || expectedMembers
           1            || 1
           3            || 3
    }
}
