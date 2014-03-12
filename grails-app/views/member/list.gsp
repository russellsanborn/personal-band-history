<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Members</title>
</head>

<body>
  <h2 id="member_name">Members</h2>
    <div class="list-group">
        <ul class="list-group">
            <g:each in="${members}">
                <g:link controller="member" action="show" id="${it?.id}" class="list-group-item">${it?.name}</g:link>
            </g:each>
        </ul>
    </div>   
</body>
</html>