package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.CreateSongPage
import personalbandhistory.page.ShowSongPage
import personalbandhistory.page.MainPage

class SongGebSpec extends GebSpec {
	def "should create a new song" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
            String songName = "test name"
            
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            CreateSongPage createSongPage = mainPage.createNewSong()
            ShowSongPage showSongPage = createSongPage.createSong(songName)
            
            then:
            assert at(ShowSongPage)
            assert showSongPage.songName.text() == songName
            
        }
}

