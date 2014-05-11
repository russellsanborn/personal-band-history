package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.CreateAlbumPage
import personalbandhistory.page.CreateBandPage
import personalbandhistory.page.ShowAlbumPage
import personalbandhistory.page.MainPage

class AlbumGebSpec extends GebSpec {
	def "should create a new album" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
            String albumName = "test name"
            
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            // Create a band first since an Album belongs to a band
            CreateBandPage createBandPage = mainPage.createNewBand()
            createBandPage.createBand("test")
            mainPage = to MainPage
            
            CreateAlbumPage createAlbumPage = mainPage.createNewAlbum()
            ShowAlbumPage showAlbumPage = createAlbumPage.createAlbum(albumName)
        
            then:
            assert at(ShowAlbumPage)
            assert showAlbumPage.albumName.text() == albumName
            
        }
}

