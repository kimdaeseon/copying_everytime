const scheduleList = {
    init : function (){
        const _this = this;
        $('#btn-schedule-save').on('click', function(){
            _this.schedule_save();
        })
    },
    schedule_save : function (){
        const data = {
            name: $('#schedule_name').val()
        }
        $.ajax({
            type: 'POST',
            url: '/api/v1/schedule/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('시간표가 등록되었습니다. ')
            window.location.href = '/schedule_list'
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    },
}

scheduleList.init()

