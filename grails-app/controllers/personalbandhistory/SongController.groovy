package personalbandhistory

class SongController {
    def scaffold = true

    def index () {
        redirect(action: "list")
    }
    
    def list() {
        [songs: Song.listOrderByName()]
    }
    
    def show(Long id) {
        Song song = Song.get(id)

        if (!song) {
            redirect uri: '/'
        }

        [song: song]
    }

}

class CreateSongCommand {
    String name
    String lyrics
    Integer trackNum
}