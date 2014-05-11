package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.CreateConcertPage
import personalbandhistory.page.ShowConcertPage
import personalbandhistory.page.MainPage

class ConcertGebSpec extends GebSpec {
	def "should create a new concert" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
            String concertTitle = "test title"
            String concertDate = "01/01/2001"
            
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            CreateConcertPage createConcertPage = mainPage.createNewConcert()
            ShowConcertPage showConcertPage = createConcertPage.createConcert(concertTitle, concertDate)
            
            then:
            assert at(ShowConcertPage)
            assert showConcertPage.concertName.text() == concertTitle
            
        }
}

