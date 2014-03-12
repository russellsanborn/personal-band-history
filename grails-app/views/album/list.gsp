<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Albums</title>
</head>

<body>
  <h2 id="album_name">Albums</h2>
    <div class="list-group">
        <ul class="list-group">
            <g:each in="${albums}">
                <g:link controller="album" action="show" id="${it?.id}" class="list-group-item">${it?.name}</g:link>
            </g:each>
        </ul>
    </div>   
</body>
</html>