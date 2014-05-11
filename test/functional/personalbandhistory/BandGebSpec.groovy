package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.CreateBandPage
import personalbandhistory.page.ShowBandPage
import personalbandhistory.page.MainPage

class BandGebSpec extends GebSpec {
	def "should create a new band" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
            String bandName = "test name"
            
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            CreateBandPage createBandPage = mainPage.createNewBand()
            ShowBandPage showBandPage = createBandPage.createBand(bandName)
            
            then:
            assert at(ShowBandPage)
            assert showBandPage.bandName.text() == bandName
            
        }
}

