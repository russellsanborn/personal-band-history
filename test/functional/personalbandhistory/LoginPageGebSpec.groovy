package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.MainPage

class LoginPageGebSpec extends GebSpec {
	def "valid user can login" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
        
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            then:
            assert at(MainPage)
            assert mainPage.logoutLinkCount == 1
        }
        
	def "invalid user cannot login" () {
            given:
            String username = "fake"
            String password = "fake"
        
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            MainPage mainPage = to MainPage
            
            then:
            assert at(MainPage)
            assert mainPage.logoutLinkCount == 0
        }
}

