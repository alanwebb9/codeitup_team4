window.Health = window.Health || {};
window.Health.Landing = window.Health.Landing || {};
window.Health.Landing.land = $.extend(true,
    window.Health.Landing.land,
    (function($) {
        "use strict";
        var vm = {};
        var option;
        var defaultOption = {
            form: null
        };


        function Searchviewmodel() {
             this.Searchtext= ko.observable()
        }


        var createViewModel = function() {

        vm.Searchview=new Searchviewmodel();
    vm.submitform= function()
        {
        $.ajax({
            url: 'http://localhost:8080/authenticate',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(Searchview),
            success: function(result){

                   },
                   error: function(XMLHttpRequest, textStatus, errorThrown) {
                       alert(XMLHttpRequest.responseJSON.message);
                   }
        });
        }

        }
           var init = function(opt) {
            option = opt || defaultOption;

            createViewModel();
            getLocation();
            ko.applyBindings(vm, option.form);
        };

        return {
            init: init,
            model: vm
        };

    }(jQuery || $)));
