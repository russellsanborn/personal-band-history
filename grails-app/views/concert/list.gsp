<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Concerts</title>
</head>

<body>
  <h2 id="concert_name">Concerts</h2>
    <table class="table table-hover table-striped">
        <tr>
            <th>Date</th>
            <th>Venue</th>
            <th>Location</th>
        </tr>
        <g:each in="${concerts}">
            <tr>
                <td><g:link controller="concert" action="show" id="${it?.id}">${it?.eventDate}</g:link></td>
                <td>${it?.venueName}</td>
                <td>${it?.location}</td>
            </tr>    
        </g:each>
    </table> 
</body>
</html>