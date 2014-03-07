package personalbandhistory

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Song)
class SongSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test #creates a song with name: '#name', lyrics: '#lyrics'"() {
        when:
            Song newSong = new Song(
                name: name, 
                lyrics: lyrics
            )
            newSong.save()
            Song createdSong = Song.first()
        then:
            if (creates == "creates") {
                assert createdSong
                Song.count() == 1
                createdSong.name == name
                createdSong.lyrics == lyrics
            }
            else {
                assert !createdSong
                Song.count() == 1
            }
        where:
            name        | lyrics        ||  creates
            ""          | ""            || "does not create"
            ""          | "test lyrics" || "does not create"
            "test name" | ""            || "creates"
            "test name" | "test lyrics" || "creates"
    }
}
