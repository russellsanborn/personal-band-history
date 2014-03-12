<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${album.name}</title>
</head>

<body>
  <h2 id="album_name">${album.name}</h2>
  <div class="row">
    <div class="col-md-6">
        Insert Picture Here</br>
        Release Date: ${album?.getAlbumDate()}</br>
        <h3>Members</h3>
        <ul class="list-group">
            <g:each in="${members}">
                <g:link controller="member" action="show" id="${it?.id}" class="list-group-item">${it?.name}</g:link>
            </g:each>
        </ul>
        
        <h3>Track List</h3>
        <ul class="list-group">
            <g:each in="${songs}">
                <g:link controller="song" action="show" id="${it?.id}" class="list-group-item">${it?.trackNum}: ${it?.name}</g:link>
            </g:each>
        </ul>
    </div>
  </div>
    
</body>
</html>