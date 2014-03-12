<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Songs</title>
</head>

<body>
    <table class="table table-hover table-striped">
        <tr>
            <th>Song</th>
        </tr>
        <g:each in="${songs}">
            <tr>
                <td><g:link controller="song" action="show" id="${it?.id}">${it?.name}</g:link></td>
            </tr>    
        </g:each>
    </table>   
</body>
</html>