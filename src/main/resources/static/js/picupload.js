function upload() {//图片上传
    var formData = new FormData($("#form1")[0]);
    $.ajax({
        url: '/car/upload',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        dataType:"text",
    success: function(data) {
        $("#hidden").html(data);
        },
        error: function(data) {
        }
    });
}