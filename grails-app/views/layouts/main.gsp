<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Personal Band History"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<meta name="pageId" content="${controllerName}.${actionName}" />
		<g:layoutHead/>
		<g:javascript library="application"/>		
		<r:layoutResources />
	</head>
	<body>
            <div class="navbar navbar-inverse" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                          <span class="sr-only">Toggle navigation</span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${createLink(uri: '/')}">Personal Band History</a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="${controllerName == 'band' ? 'active' : ''}"><g:link controller="band" action="list">Bands</g:link></li>
                            <li class="${controllerName == 'album' ? 'active' : ''}"><g:link controller="album" action="list">Albums</g:link></li>
                            <li class="${controllerName == 'song' ? 'active' : ''}"><g:link controller="song" action="list">Songs</g:link></li>
                            <li class="${controllerName == 'member' ? 'active' : ''}"><g:link controller="member" action="list">Members</g:link></li>
                            <li class="${controllerName == 'concert' ? 'active' : ''}"><g:link controller="concert" action="list">Concerts</g:link></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>

            <div class="container">
                
                <g:layoutBody/>
            </div>
            <r:layoutResources />
	</body>
</html>
