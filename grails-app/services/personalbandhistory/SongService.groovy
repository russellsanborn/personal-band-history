package personalbandhistory

class SongService {

    Song createSong (CreateSongCommand cmd) {
        new Song(
            name: cmd.name,
            lyrics: cmd.lyrics
        ).save()
    }
}
