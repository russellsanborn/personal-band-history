<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Members</title>
</head>

<body>
  <h2 id="band_name">Members</h2>
    <table class="table table-hover table-striped">
        <tr>
            <th>Member</th>
            <th>Active</th>
            <th>Instrument</th>
        </tr>
        <g:each in="${members}">
            <tr>
                <td><g:link controller="member" action="show" id="${it?.id}">${it?.name}</g:link></td>
                <td>${it?.getDateRange()}</td>
                <td>${it?.instrument}</td>
            </tr>    
        </g:each>
    </table>   
</body>
</html>