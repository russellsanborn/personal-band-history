<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${band.name}</title>
</head>

<body>
  <h2 id="band_name">${band.name}</h2>
  <div class="row">
    <div class="col-md-6">Insert Picture Here</div>
    <div class="col-md-6">
        Location: ${band.location}</br>
        Active: ${band.startDate.toString("yyyy")} - ${band.endDate.toString("yyyy")}</br>
        Bio: ${band.bio}</br>
    </div>
  
  </div>
    
</body>
</html>