<!doctype html>
<html lang="ru">
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>
<body>

<!- ОПИСАНИЕ ВКЛАДОК С ФОРМАМИ ->
<ul class="nav nav-tabs nav-fill" id="myTab" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home"
           aria-selected="true">Преподаватель</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
           aria-selected="false">Студент</a>
    </li>
</ul>

<div class="tab-content" id="myTabContent">
    <!- ФОРМА РЕГИСТРАЦИИ УЧИТЕЛЯ->
    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"><br>
        <form id="1" action="http://localhost:8080/sign-up-teacher" method="post">
            <div class="row">
                <div class="col">
                    <!- ФАМИЛИЯ ->
                    <input name="sName" type="text" class="form-control" placeholder="Фамилия">
                </div>
                <div class="col">
                    <!- ИМЯ ->
                    <input name="fName" type="text" class="form-control" placeholder="Имя">
                </div>
                <div class="col">
                    <!- ОТЧЕСТВО ->
                    <input name="thName" type="text" class="form-control" placeholder="Отчество">
                </div>
            </div>
            <br>
            <div class="form-group">
                <!- ПОЧТА ->
                <input name="login" type="email" class="form-control" id="login" aria-describedby="emailHelp"
                       placeholder="Введите почту @stud.kpfu.ru">
                <br>
                <!- ПАРОЛЬ ->
                <input name="hashPassword" type="password" class="form-control" id="password"
                       placeholder="Введите пароль">
            </div>
            <button type="submit" class="btn btn-primary">Регистрация</button>

            <input type="hidden" name="role" value="2">
        </form>
    </div>
    <!- ФОРМА РЕГИСТРАЦИИ СТУДЕНТА->
    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"><br>
        <form id="2" action="/sign-up-student" method="post">
            <div class="row">
                <div class="col">
                    <!- ФАМИЛИЯ ->
                    <input name="sName" type="text" class="form-control" placeholder="Фамилия">
                </div>
                <div class="col">
                    <!- ИМЯ ->
                    <input name="fName" type="text" class="form-control" placeholder="Имя">
                </div>
                <div class="col">
                    <!- ОТЧЕСТВО ->
                    <input name="thName" type="text" class="form-control" placeholder="Отчество">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col">
                    <!- ГРУППА ->
                    <input name="groupNumber" type="text" class="form-control" placeholder="Группа">
                </div>
                <div class="col">
                    <!- ПОЧТА ->
                    <input name="login" type="email" class="form-control" id="login" aria-describedby="emailHelp"
                           placeholder="Почта @stud.kpfu.ru">
                </div>
                <div class="col">
                    <!- КУРС ->
                    <select name="courseNumber" class="form-control" id="exampleFormControlSelect1">
                        <option value="1">1 курс</option>
                        <option value="2">2 курс</option>
                        <option value="3">3 курс</option>
                        <option value="4">4 курс</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <br>
                <!- ПАРОЛЬ ->
                <input name="hashPassword" type="password" class="form-control" id="pass" placeholder="Пароль">
                <br>
                <!- ПОВТОР ПАРОЛЯ ->
                <input type="password" class="form-control" id="repPass" placeholder="Повторите пароль">
            </div>
            <button type="submit" class="btn btn-primary">Регистрация</button>
            <input type="hidden" name="role" value="1">
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>