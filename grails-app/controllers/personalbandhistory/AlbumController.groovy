package personalbandhistory

import org.joda.time.LocalDate

class AlbumController {
    def list() {
        [albums: Album.listOrderByName()]
    }
    
    def show(Long id) {
        Album album = Album.get(id)

        if (!album) {
            redirect uri: '/'
        }

        [album: album,
        songs: album.songs.sort {it.trackNum},
        members: album.members.sort {it.name}]
    }
}

class CreateAlbumCommand {
    String Name
    LocalDate releaseDate
    Band band
}