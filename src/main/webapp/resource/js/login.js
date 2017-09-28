var login = {
    URL: {
        now: function () {
            return '/time/now';
        },
        login: function () {
            return '/login';
        }
    },
    getTime: function () {
        $.get(login.URL.login(), {}, function (result) {
            if (result) {
                var nowTime = result['data'];
                login.showTime(nowTime);
            } else {
                console.log('result: ' + result);
                alert('result: ' + result);
            }
        });
    },
    showTime: function (nowTime) {
        var seckillBox = $('#seckill-box');
        //时间格式
        seckillBox.html(nowTime);
    },
    checkForm: function () {
        alert("hell");
        $.ajax({
            type: 'POST',
            url: '/login',
            data: $("#userForm").serializeArray(),
            error: function (request) {
                alert("connect error");
            },
            success: function (data) {
                var succe = data['successs'];
                if (data && succe) {
                    window.location.href = '/list';
                } else {
                    alert(data['error']);
                }
            }
        });
    }
};