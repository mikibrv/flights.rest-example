<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="icon"
          type="image/png"
          href="<@spring.url '/static/img/falcon.png'/>">
    <title>Book a Flight now!</title>

    <link rel="stylesheet" href="<@spring.url '/static/css/abstract.css'/>"/>

    <script>var BASE_URL ="<@spring.url '/'/>";</script>

    <script type="text/javascript" src="<@spring.url '/static/js/jquery-1.11.1.min.js'/>"></script>

</head>

<body>


<#include "../${viewName}.ftl"/>


</body>
</html>

