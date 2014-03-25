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
    
    def album_image() {
        def album = Album.get(params.id)
        if (!album) {
          response.sendError(404)
          return
        }
        OutputStream out = response.outputStream
        out.write(album?.albumImage)
        out.close()
    }
}

class CreateAlbumCommand {
    String Name
    LocalDate releaseDate
    Band band
}