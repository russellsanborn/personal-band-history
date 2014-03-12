package personalbandhistory

import org.joda.time.LocalDate

class AlbumService {

    Album createAlbum (CreateAlbumCommand cmd) {
        new Album(
            name: cmd.name,
            releaseDate: cmd.releaseDate
        ).save()
    }
    
    Song addSong(Album album, String name, String lyrics, Integer trackNum) {
        Song newSong = new Song (
            name: name,
            lyrics: lyrics,
            trackNum: trackNum
        ).save()
        
        album.addToSongs(newSong)
        return newSong
    }
    
    Member addMember(Album album, String name, String instrument, LocalDate startDate, LocalDate endDate) {
        Member newMember = new Member (
            name: name,
            instrument: instrument,
            startDate: startDate,
            endDate: endDate
        ).save()
        
        album.addToMembers(newMember)
        return newMember
    }
}