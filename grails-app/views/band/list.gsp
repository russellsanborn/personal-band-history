<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Bands</title>
</head>

<body>
  <h2 id="band_name">Bands</h2>
    <div class="list-group">
        <g:each in="${bands}">
            <g:link controller="band" action="show" id="${it?.id}" class="list-group-item list-group-item-info">${it?.name}</g:link>
        </g:each>
    </div>   
</body>
</html>