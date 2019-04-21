<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container delete">
    <div class="row align-items-center h-100">
        <div class="col class_newcourse">
            <div class="thumbnail">
                <div class="caption">
                    <h2> ${course.getName()}</h2>
                    <h4>Professor: Prepod1</h4>
                    <p id="describtion">${course.getDescription()}</p>
                    <h5>Quota: ${course.getQuota()}</h5>
                    <#if course.isRating() == true>
                            <h5>Selection type: rating</h5>
                    <#else>
                            <h5>Selection type: interview</h5>
                    </#if>
                    <h5>Section: ${course.getSection()}</h5>
                    <h5>Presentation:</h5><form><input type="submit" name="download"  value="download"></form></h5>
                    <h5>Deadline: ${course.getDeadline()}</h5>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>