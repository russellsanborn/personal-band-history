package personalbandhistory.page

import geb.Page
import personalbandhistory.page.CreateAlbumPage
import personalbandhistory.page.CreateBandPage
import personalbandhistory.page.CreateConcertPage
import personalbandhistory.page.CreateSongPage

class MainPage extends Page {
    static url = ""
    
    static at = {title == "Personal Band History"}
    
    static content = {
        logoutLinkCount {$('a', id:'log_out_nav_bar_link').size()}
        albumDropdownLink {$("#album_nav_bar_dropdown")}
        bandDropdownLink {$("#band_nav_bar_dropdown")}
        concertDropdownLink {$("#concert_nav_bar_dropdown")}
        songDropdownLink {$("#song_nav_bar_dropdown")}
        
        createBandLink(wait: true, to: CreateBandPage) {$("#create_band_nav_bar_link")}
        createAlbumLink(wait: true, to: CreateAlbumPage) {$("#create_album_nav_bar_link")}
        createSongLink(wait: true, to: CreateSongPage) {$("#create_song_nav_bar_link")}
        createConcertLink(wait: true, to: CreateConcertPage) {$("#create_concert_nav_bar_link")}
    }
    
    CreateAlbumPage createNewAlbum() {
        albumDropdownLink.click()
        createAlbumLink.click()
        
        return browser.page
    }
    
    CreateBandPage createNewBand() {
        bandDropdownLink.click()
        createBandLink.click()
        
        return browser.page
    }
    
    CreateConcertPage createNewConcert() {
        concertDropdownLink.click()
        createConcertLink.click()
        
        return browser.page
    }
    
    CreateSongPage createNewSong() {
        songDropdownLink.click()
        createSongLink.click()
        
        return browser.page
    }
}

