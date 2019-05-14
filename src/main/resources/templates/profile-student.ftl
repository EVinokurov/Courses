<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Profile</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<!--Main Navigation-->
<header>
    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
        <div class="container">
            <!-- Brand -->
            <!-- Collapse -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Links -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <!-- Left -->
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link waves-effect" href="#">Courses
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link waves-effect" href="#" target="_blank">Students(Profile if stud)</a>
                    </li>
                </ul>

                <!-- Right -->
                <ul class="navbar-nav nav-flex-icons">
                    <li class="nav-item">
                        <a class="nav-link waves-effect"
                           target="_blank">Log In</a>
                    </li>
                </ul>

            </div>

        </div>
    </nav>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-offset-8 col-md-10 mt-5 pt-5 col-lg-offset-6 col-lg-6">
            <img src="img/img.jpg">
        </div>
        <div class="col-md-offset-2 col-md-8 mt-5 pt-5 col-lg-offset-3 col-lg-6">
            <div class="well profile">
                <h3>Имя: ${user.getFName()}</h3>
                <h3>Фамилия: ${user.getSName()}</h3>
                <h3>Отчество: ${user.getThName()}</h3>
                <h3>Номер группы: ${user.getGroupNumber()}</h3>
                <h3>Поданные заявки:</h3>
                <#list course as name>
                    <p>Название курса: ${name}</p>
                    <p>Описание курса: ${description}</p>
                    <a href=${presentation_path}>презентация</a>
                </#list>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>