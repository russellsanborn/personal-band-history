package personalbandhistory

import spock.lang.*
import org.joda.time.LocalDate

/**
 *
 */
class AlbumServiceSpec extends Specification {
    AlbumService albumService
    
    def setup() {
    }

    def cleanup() {
    }

    void "test an album can be created"() {
        when:
            String newName = "test album name"
            LocalDate newReleaseDate = new LocalDate(2011, 1, 1)
        
            CreateAlbumCommand newCreateAlbumCommand = new CreateAlbumCommand (
                name: newName,
                releaseDate: newReleaseDate
            )
            
            Album createdAlbum = albumService.createAlbum(newCreateAlbumCommand)

        then:
            Album.count() == 1
            createdAlbum.name == newName
            createdAlbum.releaseDate == newReleaseDate
    }
    
    void "test a member can be added to an album"() {
        when:
            String newMemberName1 = "test member 1"
            String newMemberName2 = "test member 2"
        
            CreateAlbumCommand newCreateAlbumCommand = new CreateAlbumCommand (
                name: "test album name",
                releaseDate: new LocalDate(2011, 1, 1)
            )
            
            Album createdAlbum = albumService.createAlbum(newCreateAlbumCommand)
            
            albumService.addMember(createdAlbum, newMemberName1, "test instrument", new LocalDate(2011, 1, 1), new LocalDate(2014, 1, 1))
            albumService.addMember(createdAlbum, newMemberName2, "test instrument", new LocalDate(2011, 1, 1), new LocalDate(2014, 1, 1))
        then:
            assert createdAlbum.members.size() == 2
            assert Member.findByName(newMemberName1)
            assert Member.findByName(newMemberName2)
    }
    
    void "test a song can be added to an album"() {
        when:
            String newSongName1 = "test song 1"
            String newSongName2 = "test song 2"
        
            CreateAlbumCommand newCreateAlbumCommand = new CreateAlbumCommand (
                name: "test album name",
                releaseDate: new LocalDate(2011, 1, 1)
            )
            
            Album createdAlbum = albumService.createAlbum(newCreateAlbumCommand)
            
            albumService.addSong(createdAlbum, newSongName1, "test lyrics")
            albumService.addSong(createdAlbum, newSongName2, "test lyrics")
        then:
            assert createdAlbum.songs.size() == 2
            assert Song.findByName(newSongName1)
            assert Song.findByName(newSongName2)
    }    
}
