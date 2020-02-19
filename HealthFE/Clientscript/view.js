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
vm.Activityitem=ko.observable();
vm.userprofile=ko.observable();
        vm.Searchview=new Searchviewmodel();
    vm.searchactivities= function()
        {
          var location={
            "latitude":53.88,
           "longitude":-8.57
          }
        $.ajax({
            url: 'http://health.com:5000/api/area_search',
            type: 'POST',
            headers:{
              "Access-Control-Allow-Origin":"*"
            },
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(location),
            success: function(result){
vm.Activityitem(result)
                   },
                   error: function(XMLHttpRequest, textStatus, errorThrown) {
                       alert(XMLHttpRequest.responseJSON.message);
                   }
        });
        }
        vm.Loginuser= function()
            {
              var user={
              "email":"abcdd",
              "password":"abcd"
              }
            $.ajax({
                url: 'http://health.com:5000/api/user/signin',
                type: 'GET',
                headers:{
                  "Access-Control-Allow-Origin":"*"
                },
                contentType: 'application/json; charset=utf-8',
                data:user,
                success: function(result){
    vm.userprofile(result);
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
