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
    
</body>
</html>