package personalbandhistory.page

import geb.Page
import personalbandhistory.page.ShowMemberPage

class CreateMemberPage extends Page {
    static url = "member/create"
    
    static at = {$("meta", name: "pageId").getAttribute("content") == "member.create"}
    
    static content = {
        memberNameField(wait: true) {$("#member_name")}
        createMemberButton(wait: true, to: ShowMemberPage) {$("#create_member_button")}
    }
    
    ShowMemberPage createMember(String memberName) {
        memberNameField.value(memberName)
        createMemberButton.click()
        
        return browser.page
    }
}