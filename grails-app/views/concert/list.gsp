<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Concerts</title>
</head>

<body>
  <h2 id="concert_name">Concerts</h2>
    <div class="list-group">
        <ul class="list-group">
            <g:each in="${concerts}">
                <g:link controller="concert" action="show" id="${it?.id}" class="list-group-item">${it?.eventDate}</g:link>
            </g:each>
        </ul>
    </div>   
</body>
</html>