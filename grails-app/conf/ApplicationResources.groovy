modules = {
    // If we're not running in the development environment, use minified JS and CSS files.
    boolean isDevEnv = (Environment.current == Environment.DEVELOPMENT)
    String useMin = (isDevEnv) ? '' : 'min.'

    jQuery {
        resource url: "/vendor/jquery/jquery.${useMin}js", exclude: ['minify']
    }

    bootstrap {
        dependsOn 'jQuery'

        resource url: "/vendor/bootstrap/dist/css/bootstrap.${useMin}css", exclude: ['minify'], disposition: 'head'
        resource url: "/vendor/bootstrap/dist/css/bootstrap-theme.${useMin}css", exclude: ['minify'], disposition: 'head'
        resource url: "/vendor/bootstrap/dist/js/bootstrap.${useMin}js", exclude: ['minify']
    }
    
    application {
        dependsOn 'bootstrap'

        resource url: '/css/app.css', disposition: 'head'
    }
}