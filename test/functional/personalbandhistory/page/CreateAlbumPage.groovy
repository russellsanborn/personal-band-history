package personalbandhistory.page

import geb.Page
import personalbandhistory.page.ShowAlbumPage

class CreateAlbumPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content")  == "album.create"}
    
    static content = {
        albumNameField (wait: true)  {$("#album_name")}
        createAlbumButton (wait: true, to: ShowAlbumPage) {$("#create_album_button")}
    }
    
    ShowAlbumPage createAlbum(String albumName) {
        albumNameField.value(albumName)
        createAlbumButton.click()
        
        return browser.page
    }
}