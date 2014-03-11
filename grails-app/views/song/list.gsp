<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Songs</title>
</head>

<body>
  <h2 id="song_name">Songs</h2>
    <div class="list-group">
        <g:each in="${songs}">
            <g:link controller="song" action="show" id="${it?.id}" class="list-group-item list-group-item-info">${it?.name}</g:link>
        </g:each>
    </div>   
</body>
</html>