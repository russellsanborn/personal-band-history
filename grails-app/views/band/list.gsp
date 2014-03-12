<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Bands</title>
</head>

<body>
  <h2 id="band_name">Bands</h2>
    <div class="list-group">
        <ul class="list-group">
            <g:each in="${bands}">
                <g:link controller="band" action="show" id="${it?.id}" class="list-group-item">${it?.name}</g:link>
            </g:each>
        </ul>
    </div>   
</body>
</html>