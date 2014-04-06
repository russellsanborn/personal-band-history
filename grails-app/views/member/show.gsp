<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${member.name}</title>
</head>

<body>
  <h2 id="member_name">${member.name}</h2>
  <div class="row">
    <div class="col-md-6">
        Instrument: ${member?.instrument}</br>
        Active: ${member?.getDateRange()}</br>
  
        <div id="edit_member_button">
            <g:link action="edit" id="${member?.id}" class="btn btn-success">Edit</g:link>
        </div>
    </div>
   </div>
    
</body>
</html>