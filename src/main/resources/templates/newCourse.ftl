<html>
<title>New</title>
<body>

<form method="post" enctype="multipart/form-data">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input required type="text" class="form-control" name="name" aria-describedby="" placeholder="Enter course name">
                    </div>
                    <div class="form-group">
                        <label for="input">Professor</label>
                        <select required class="form-control" name="teacher" id="exampleFormControlSelect1">
                            <#list teachers as teacher>
                            <option value="${teacher.getId()}">${teacher.getId()}</option>
                            </#list>
                        </select>

                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Course</label>
                        <select required class="form-control" name="year" id="exampleFormControlSelect1">
                            <option value = "1">1</option>
                            <option value = "2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Selection </label>
                        <select required class="form-control" name="rating" id="exampleFormControlSelect1">
                            <option value="True">rating</option>
                            <option value = "False">interview</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Section</label>
                        <select required class="form-control1" name = "section">
                            <option value="section 1">section 1</option>
                            <option value="section 2">section 2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Quota</label>
                        <input required name="quota" type="number">
                    </div>
                    <div class="form-group">
                        <label>Deadline</label>
                        <input required type="date" name="deadline" class="form-control" aria-describedby="" placeholder="12.12.12">
                    </div>
                    <div class="form-group">
                    </div>
                    <label>Description</label>
                    <textarea required name = "description" class="form-control" rows="3" class="form-control" aria-describedby="" placeholder="Enter course information"></textarea>
                    <input type="file" name="file" id="file">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit">Save</button>
            </div>
        </div>
    </div>
</form>
<#if error??>
    <h1>Обкекался?</h1>
</#if>

</body>
</html>