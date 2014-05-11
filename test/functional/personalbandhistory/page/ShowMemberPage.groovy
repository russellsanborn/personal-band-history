package personalbandhistory.page

import geb.Page

class ShowMemberPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "member.show"}
    
    static content = {
        memberName(wait: true) {$("#member_name")}
    }
}

