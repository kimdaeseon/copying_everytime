const schedule = {
    dataMon : [],
    dataTue : [],
    dataWen : [],
    dataThu : [],
    dataFri : [],
    ListOfSubject : [],
    colorTable : [1,'red', 'yellow', 'brown', 'blue', 'lime', 'cyan', 'violet', 'green'],
    calcTime : function(timeA, timeB){
        let hourA = parseInt(timeA/100)
        let minuteA = timeA % 100
        let hourB = parseInt(timeB/100)
        let minuteB = timeB % 100
        return (hourA - hourB) * 100 + 100 * ((minuteA - minuteB) / 60)

    },
    calcData : function(array){
        let string = `<div style="height: ${this.calcTime(array[0].startTime, 900)}px"></div>`
        string += `<div style="height: ${this.calcTime(array[0].finishTime, array[0].startTime)}px; background-color: ${array[0].color}"> ${array[0].name} </div>`

        for(let i = 1; i < array.length; i++){
            string += `<div style="height: ${this.calcTime(array[i].startTime, array[i - 1].finishTime)}px"></div>`
            string += `<div style="height: ${this.calcTime(array[i].finishTime, array[i].startTime)}px; background-color: ${array[i].color}"> ${array[i].name} </div>`
        }
        return string
    },
    renderSchedule : function(day){
        if(day == '월'){
            let string = this.calcData(this.dataMon);
            string = `<div class="category">월요일</div>` + string;
            $('.monday').empty();
            $('.monday').append(string);
        }
        if(day == '화'){
            let string = this.calcData(this.dataTue);
            string = `<div class="category">화요일</div>` + string;
            $('.tuesday').empty();
            $('.tuesday').append(string);
        }
        if(day == '수'){
            let string = this.calcData(this.dataWen);
            string = `<div class="category">수요일</div>` + string;
            $('.wednesday').empty();
            $('.wednesday').append(string);
        }
        if(day == '목'){
            let string = this.calcData(this.dataThu);
            string = `<div class="category">목요일</div>` + string;
            $('.thursday').empty();
            $('.thursday').append(string);
        }
        if(day == '금'){
            let string = this.calcData(this.dataFri);
            string = `<div class="category">금요일</div>` + string;
            $('.friday').empty();
            $('.friday').append(string);
        }
    },
    checkData : function(data, array){
        for (let i of array){
            if(data.startTime >= i.startTime && data.startTime < i.finishTime){
                alert("시간이 중복됩니다!")
                return false;
            }
            if(data.finishTime > i.startTime && data.finishTime <= i.finishTime){
                alert("시간이 중복됩니다!")
                return false;
            }
        }
        return true;
    },
    insertData : function(data, array){
        array.push({
            name : data.name,
            startTime : data.startTime,
            finishTime: data.finishTime,
            credit : data.credit,
            color : this.colorTable[this.colorTable[0]]
        })
        array.sort(function(a ,b){
            return a.startTime - b.startTime
        })
    },
    addData : function(data){
        const days = data.day.split('/');
        console.log(days)
        if (days.includes('월')){
            if(!this.checkData(data, this.dataMon)) return;
            this.insertData(data, this.dataMon);
            this.renderSchedule('월');
        }
        if (days.includes('화')){
            if(!this.checkData(data, this.dataTue)) return;
            this.insertData(data, this.dataTue);
            this.renderSchedule('화');
        }
        if (days.includes('수')){
            if(!this.checkData(data, this.dataWen)) return;
            this.insertData(data, this.dataWen);
            this.renderSchedule('수');
        }
        if (days.includes('목')){
            if(!this.checkData(data, this.dataThu)) return;
            this.insertData(data, this.dataThu);
            this.renderSchedule('목');
        }
        if (days.includes('금')){
            if(!this.checkData(data, this.dataFri)) return;
            this.insertData(data, this.dataFri);
            this.renderSchedule('금');
        }
        this.colorTable[0] = (this.colorTable[0]) % (this.colorTable.length - 1) + 1
        this.ListOfSubject.push({
            scheduleName : $('.schedule-name').text(),
            userName : "default",
            subjectName : data.name
        })
    },
    init : function (){
        const _this = this;
        $('#btn-schedule-add').on('click', function(){
            _this.add_subject();
        })
        const data = $('.schedule-name').text()
        $.ajax({
            type: 'POST',
            url: '/api/v1/schedule/initialize',
            contentType: 'application/json; charset=utf-8',
            data: data
        }).done(function(data, textStatus, xhr){
            let result = JSON.parse(data);
            console.log(data);
            for(let i of result){
                _this.addData(i)
            }
        }).fail(function (error){
            alert(JSON.stringify(error))
        })
    },
    add_subject : function(){
        const data = {
            list : this.ListOfSubject
        }
        $.ajax({
            type: 'POST',
            url: '/api/v1/schedule/addSubject',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data.list)
        }).done(function(){
            alert('시간표가 등록되었습니다. ')
            window.location.href = '/schedule_list'
        }).fail(function (error){
            alert(JSON.stringify(error))
        })
    }

}
const add = function(number){
    const subject = {
        name : $('#' + number + '-name').text(),
        startTime : $('#' + number + '-startTime').text(),
        finishTime : $('#' + number + '-finishTime').text(),
        credit : $('#' + number + '-credit').text(),
        day : $('#' + number + '-day').text(),
    }
    schedule.addData(subject);
}

schedule.init()

