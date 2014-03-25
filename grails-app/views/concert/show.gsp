<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${concert?.title}</title>
</head>

<body>
  <h2 id="concert_name">${concert?.title}</h2>
  <div class="row">
    <div class="col-md-6">
        Title: ${concert?.title}</br>
        Venue: ${concert?.venueName}</br>
        Event Date: ${concert?.eventDate}</br>
        Location: ${concert?.location}</br>
        <ul class="list-group">
            <g:each in="${bands}">
                <li class="list-group-item">${it}</li>
            </g:each>
        </ul>
    </div>
    </div>
  
  </div>
    
</body>
</html>