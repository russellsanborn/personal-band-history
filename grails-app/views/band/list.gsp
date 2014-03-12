<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Bands</title>
</head>

<body>
  <h2 id="band_name">Bands</h2>
    <table class="table table-hover table-striped">
        <tr>
            <th>Band</th>
            <th>Active</th>
            <th>Location</th>
        </tr>
        <g:each in="${bands}">
            <tr>
                <td><g:link controller="band" action="show" id="${it?.id}">${it?.name}</g:link></td>
                <td>${it?.getDateRange()}</td>
                <td>${it?.location}</td>
            </tr>    
        </g:each>
    </table>   
</body>
</html>