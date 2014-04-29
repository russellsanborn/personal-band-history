<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Users</title>
</head>

<body>
  <h2 id="user_name">Users</h2>
    <table class="table table-hover table-striped">
        <tr>
            <th>Username</th>
            <th>Account Expired</th>
            <th>Account Locked</th>
            <th>Locked Enabled</th>
            <th>Password Expired</th>
        </tr>
        <g:each in="${users}">
            <tr>
                <td><g:link controller="user" action="show" id="${it?.id}">${it?.username}</g:link></td>
                <td>${it?.accountExpired}</td>
                <td>${it?.accountLocked}</td>
                <td>${it?.enabled}</td>
                <td>${it?.passwordExpired}</td>
            </tr>    
        </g:each>
    </table>   
</body>
</html>