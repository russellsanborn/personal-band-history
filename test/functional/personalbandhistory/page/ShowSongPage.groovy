package personalbandhistory.page

import geb.Page

class ShowSongPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "song.show"}
    
    static content = {
        songName(wait: true) {$("#song_name")}
    }
}

