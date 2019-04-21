<html>
<title>Posts</title>
<body>

<form method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${course.getId()}">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" value="${course.getName()}" aria-describedby="" placeholder="Enter course name">
                    </div>
                    <div class="form-group">
                        <label for="input">Professor</label>
                        <select class="form-control" name="teacher" id="exampleFormControlSelect1">
                            <option value="${course.getTeacher().getId()}">${course.getTeacher().getName()}</option>
                        </select>

                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Course</label>
                        <select d class="form-control" name="year" id="exampleFormControlSelect1">
                            <option selected="selected"  value="${course.getYear()}"> ${course.getYear()}</option>
                            <option value = "1">1</option>
                            <option value = "2">2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Selection </label>
                        <select class="form-control" name="rating"
                                id="exampleFormControlSelect1">
                             <#if course.isRating() == true>
                            <h5>Selection type: rating</h5>
                             <#else>
                            <h5>Selection type: interview</h5>
                             </#if>
                            <option value="True">rating</option>
                            <option value = "False">interview</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Section</label>
                        <select class="form-control1" name = "section">
                            <option selected value = "${course.getSection()}"> ${course.getSection()}</option>
                            <option value="section 1">section 1</option>
                            <option value="section 2">section 2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Quota</label>
                        <select class="form-control" name= "quota">
                            <option selected value="${course.getQuota()}">${course.getQuota()}</option>
                            <option value = "5">5</option>
                            <option value = "10">10</option>
                            <option value = "15">15</option>
                            <option>25</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Deadline</label>
                        <input type="date" name="deadline" value="${course.getDeadline()}" class="form-control" aria-describedby="">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlFile1">Presentation</label>
                        <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1" />
                    </div>
                    <label>Description</label>
                    <textarea name = "description" class="form-control" rows="3" class="form-control" aria-describedby=""  placeholder="Enter course information"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit">Save</button>
            </div>
        </div>
    </div>
</form>

</body>
</html>