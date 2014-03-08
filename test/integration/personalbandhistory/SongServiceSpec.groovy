package personalbandhistory

import spock.lang.*

/**
 *
 */
class SongServiceSpec extends Specification {
    SongService songService
    
    def setup() {
    }

    def cleanup() {
    }

    void "test an song can be created"() {
        when:
            String newName = "test name"
            String newLyrics = "test lyrics"
        
            CreateSongCommand newCreateSongCommand = new CreateSongCommand (
                name: newName,
                lyrics: newLyrics
            )
            
            Song createdSong = songService.createSong(newCreateSongCommand)

        then:
            Song.count() == 1
            createdSong.name == newName
            createdSong.lyrics == newLyrics
    }
}
