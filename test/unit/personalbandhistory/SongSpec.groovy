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
    void "test #creates a song with name: '#name', lyrics: '#lyrics', trackNum: '#trackNum'"() {
        when:
            Song newSong = new Song(
                name: name, 
                lyrics: lyrics,
                trackNum: trackNum
            )
            newSong.save()
            Song createdSong = Song.first()
        then:
            if (creates == "creates") {
                assert createdSong
                assert Song.count() == 1
                assert createdSong.name == name
                assert createdSong.lyrics == lyrics
                assert createdSong.trackNum == trackNum
            }
            else {
                assert !createdSong
                assert Song.count() == 0
            }
        where:
            name        | lyrics        | trackNum  ||  creates
            null        | null          | null      || "does not create"
            null        | "test lyrics" | null      || "does not create"
            null        | null          | 5         || "does not create"
            "test name" | null          | null      || "creates"
            "test name" | "test lyrics" | 5         || "creates"
    }
}
