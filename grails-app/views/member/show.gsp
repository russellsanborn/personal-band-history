<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>${member.name}</title>
</head>

<body>
  <h2 id="member_name">${member.name}</h2>
  <div class="row">
    <div class="col-md-6">
        Instrument: ${member.instrument}</br>
        <g:if test="${member?.startDate && member?.endDate}"> 
            Active: ${member?.startDate.toString("yyyy")} - ${member?.endDate.toString("yyyy")}</br>
        </g:if>
    </div>
  
  </div>
    
</body>
</html>