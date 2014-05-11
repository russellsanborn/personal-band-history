package personalbandhistory

import geb.Page
import geb.spock.GebSpec
import personalbandhistory.page.LoginPage
import personalbandhistory.page.CreateMemberPage
import personalbandhistory.page.ShowMemberPage
import personalbandhistory.page.MainPage

class MemberGebSpec extends GebSpec {
	def "should create a new member" () {
            given:
            String username = "admin"
            String password = "enteranewpasswordyo"
            String memberName = "test name"
            
            when:
            LoginPage loginPage = to LoginPage
            loginPage.login(username, password)
            
            CreateMemberPage createMemberPage = to CreateMemberPage
            ShowMemberPage showMemberPage = createMemberPage.createMember(memberName)
            
            then:
            assert at(ShowMemberPage)
            assert showMemberPage.memberName.text() == memberName
            
        }
}

