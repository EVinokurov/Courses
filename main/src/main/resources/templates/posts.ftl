<!DOCTYPE html>
<!-- создание, редактирование курсов деканатом -->
<html>
<head>
    <title>DekCourse</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css "/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="mainTitleForDekan.html">Main title<span class="sr-only"></span></a></li>
                <li><a href="students.html">Students</a></li>
                <li class="active"><a href="DekCourse.jsp">Course list</a></li>
                <li ><a href="Messages.html">Messages</a></li>
                <li ><a href="mainTitleForUser.html">Logout</a></li>
            </ul>
        </div>
    </div>
    </div>
</nav>
<div class="container" id="main">
    <h1>Course list (dekan)</h1>
    <a href="/new">
        <button   data-toggle="modal">
            New course
        </button>
    </a>
    <form method="post">
        <h7>Search</h7>
    <input type="search" name="search" placeholder="Enter course name"/>
    </form>
</div>
<!-- Модальное окно -->
<#list courses as course>
    <div class="container delete">
        <div class="row align-items-center h-100">
            <div class="col class_newcourse">
                <div class="thumbnail">
                    <div class="caption">
                        <a href="/course/${course.getId()}"><h2>  ${course.getName()}</h2>  </a>
                        <h4>Professor: </h4>
                        <p id="describtion">${course.getDescription()}</p>
                        <h5>Quota: ${course.getQuota()}</h5>
                        <#if course.isRating() == true>
                            <h5>Selection type: rating</h5>
                        <#else>
                            <h5>Selection type: interview</h5>
                        </#if>
                        <h5>Section: ${course.getSection()}</h5>
                        <h5>Presentation:</h5>
                        <h5>Deadline: ${course.getDeadline()}</h5>

                        </form> <form method="get">
                        <p><button name="id" value="${course.getId()}" type="submit" class="btn btn-primary">
                            Redact course
                        </button></p>
                    </form>
                    </div>
                    <form method="post">
                        <p><button name="id" value="${course.getId()}" type="submit" class="btn btn-primary">
                            Delete course
                        </button></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>
</#list>
</form>
</body>
</html>