package personalbandhistory.page

import geb.Page

class ShowAlbumPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "album.show"}
    
    static content = {
        albumName(wait: true) {$("#album_name")}
        editAlbumButton(wait: true) {$("#edit_album_button")}
    }
}

