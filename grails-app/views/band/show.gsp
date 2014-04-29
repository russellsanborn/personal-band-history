<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${band.name}</title>
</head>

<body>
  <h2 id="band_name">${band.name}</h2>
  <div class="row">
    <div class="col-md-6">
        <g:if test="${band.bandImage}">
            <img class="img-rounded img-responsive" src="${createLink(controller:'band', action:'band_image', id:band.id)}" />
        </g:if>
        Location: ${band?.location}</br>
        Active: ${band?.getDateRange()}</br>
        Bio: ${band?.bio}</br>

        <h3>Members</h3>
        <ul class="list-group">
            <g:each in="${members}">
                <g:link controller="member" action="show" id="${it?.id}" class="list-group-item">${it?.toString()}</g:link>
            </g:each>
        </ul>

        <h3>Albums</h3>
        <ul class="list-group">
            <g:each in="${albums}">
                <g:link controller="album" action="show" id="${it?.id}" class="list-group-item">${it?.name}</g:link>
            </g:each>
        </ul>
    </div>
  </div>
  
  <sec:ifAnyGranted roles="ROLE_USER,ROLE_ADMIN">
    <div id="edit_band_button">
        <g:link action="edit" id="${band?.id}" class="btn btn-success">Edit</g:link>
    </div>
  </sec:ifAnyGranted>    
    
    
</body>
</html>