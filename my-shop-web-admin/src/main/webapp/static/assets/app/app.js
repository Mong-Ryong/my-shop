var App = function () {

    var _masterCheckbox;
    var _checkbox;



    /*
    初始化ICheck
     */

    var handlerInitCherkbox = function () {
        //激活
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        //获取控制端的checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        //获取全部checkbox集合
        _checkbox = $('input[type="checkbox"].minimal');

    };

    /**
     * Checkbox的全选功能
     */
    var handlerCheckboxAll= function () {
        _masterCheckbox.on("ifClicked", function (e) {
            console.log(e.target.checked);
            //返回true表示没有选中
            if (e.target.checked){
                _checkbox.iCheck('uncheck')
            }
            //否则就是选中状态
            else {
                _checkbox.iCheck('check')

            }
        });

    };
    return{
        init :function(){
            handlerInitCherkbox();
            handlerCheckboxAll();
        },
        getCheckbox:function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
});