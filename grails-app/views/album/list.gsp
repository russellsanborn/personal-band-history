<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Albums</title>
</head>

<body>
  <h2 id="album_name">Albums</h2>
    <table class="table table-hover table-striped">
        <tr>
            <th>Album</th>
            <th>Release Date</th>
            <th>Band</th>
        </tr>
        <g:each in="${albums}">
            <tr>
                <td><g:link controller="album" action="show" id="${it?.id}">${it?.name}</g:link></td>
                <td>${it?.getAlbumDate()}</td>
                <td><g:link controller="band" action="show" id="${it?.band?.id}">${it?.band?.name}</g:link></td>
            </tr>    
        </g:each>
    </table>   
</body>
</html>