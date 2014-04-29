<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${song.name}</title>
</head>

<body>
  <div class="jumbotron">
    <h1 id="song_name">${song.name}</h1>
    <p>
        <strong>Lyrics</strong></br>
        ${song.lyrics}
    </p>
    
  </div>
  
  <sec:ifAnyGranted roles="ROLE_USER,ROLE_ADMIN">
    <div id="edit_show_button">
        <g:link action="edit" id="${song?.id}" class="btn btn-success">Edit</g:link>
    </div>
  </sec:ifAnyGranted>  
</body>
</html>