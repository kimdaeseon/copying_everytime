const main = {
    init : function (){
        const _this = this;
        $('#btn-post-save').on('click', function(){
            _this.post_save();
        })
        $('#btn-board-save').on('click', function(){
            _this.board_save();
        })
        $('#btn-update').on('click', function(){
            _this.update();
        })
        $('#btn-delete').on('click', function(){
            _this.delete();
        })
    },
    post_save : function (){
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            board: $('#board').text()
        }

        $.ajax({
            type: 'POST',
            url: '/api/v1/post/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다. ')
            window.location.href = '/boards/' + data.board
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    },
    board_save : function (){
        const data = {
            name: $('#board_name').val()
        }
        $.ajax({
            type: 'POST',
            url: '/api/v1/board/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('게시판이 등록되었습니다. ')
            window.location.href = '/board_list'
        }).fail(function (error) {
            alert(JSON.stringify(error))
        })
    },
    update : function(){
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        }
        const id = $('#id').val()
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.')
            window.location.href='/'
        }).fail(function(error){
            alert(JSON.stringify(error))
        })
    },
    delete : function(){
        const id = $('#id').val()
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.')
            window.location.href='/'
        }).fail(function(error){
            alert(JSON.stringify(error))
        })
    }
}

main.init()