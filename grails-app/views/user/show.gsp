<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${userInstance?.username}</title>
</head>

<body>
  <h2 id="band_name">${userInstance?.username}</h2>
  <div class="row">
    <div class="col-md-6">
        Username: ${userInstance?.username}</br>
        Account Expired: ${userInstance?.accountExpired}</br>
        Account Locked: ${userInstance?.accountLocked}</br>
        Enabled: ${userInstance?.enabled}</br>
        Password Expired: ${userInstance?.passwordExpired}</br>
    </div>
  </div>
  
  <sec:ifAnyGranted roles="ROLE_ADMIN">
    <div id="edit_user_button">
        <g:link action="edit" id="${userInstance?.id}" class="btn btn-success">Edit</g:link>
    </div>
  </sec:ifAnyGranted>    

</body>
</html>
