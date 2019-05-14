<!doctype html>
<html lang="ru">
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Редактирование</title>
</head>
<body>
<form id="2" action="/edit-profile" method="post">
    <div class="row">
        <div class="col">
            <!- ФАМИЛИЯ ->
            <input name="sName" type="text" class="form-control" value=${user.getSName()}>
        </div>
        <br>
        <div class="col">
            <!- ИМЯ ->
            <input name="fName" type="text" class="form-control" value=${user.getFName()}>
        </div>
        <br>
        <div class="col">
            <!- ОТЧЕСТВО ->
            <input name="thName" type="text" class="form-control" value=${user.getThName()}>
        </div>
        <br>
    </div>
    <br>
    <div class="row">
        <div class="col">
            <!- ГРУППА ->
            <input name="groupNumber" type="text" class="form-control" value=${user.getGroupNumber()}>
        </div>
        <div class="col">
            <!- КУРС ->
            <select name="courseNumber" class="form-control" value=${user.getCourseNumber()}>
                <option value="1">1 курс</option>
                <option value="2">2 курс</option>
                <option value="3">3 курс</option>
                <option value="4">4 курс</option>
            </select>
        </div>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Сохранить изменения</button>
    <input type="hidden" name="role" value="2">
</form>
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