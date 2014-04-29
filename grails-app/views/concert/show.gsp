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
  <sec:ifAnyGranted roles="ROLE_USER,ROLE_ADMIN">
    <div id="edit_concert_button">
        <g:link action="edit" id="${concert?.id}" class="btn btn-success">Edit</g:link>
    </div>
  </sec:ifAnyGranted>  
</body>
</html>