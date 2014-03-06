package personalbandhistory

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Album)
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
}
