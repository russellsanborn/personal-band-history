package personalbandhistory.page

import geb.Page
import personalbandhistory.page.ShowSongPage

class CreateSongPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "song.create"}
    
    static content = {
        songNameField (wait: true) {$("#song_name")}
        createSongButton (wait: true, to: ShowSongPage) {$("#create_song_button")}
    }
    
    ShowSongPage createSong(String songName) {
        songNameField.value(songName)
        createSongButton.click()
        
        return browser.page
    }
}