window.OTG = window.OTG || {};
window.OTG.dashboard = window.OTG.dashboard || {};
window.OTG.dashboard.db = $.extend(true,
    window.OTG.dashboard.db,
    (function($) {
        "use strict";
        var vm = {};
        var option;
        var defaultOption = {
            form: null
        };
        var token;
var headertoken;
        var createViewModel = function() {

        vm.Usercard=ko.observableArray([]);


          var urltocall="http://54.185.61.61:8080/api/card/GetLinkcards/1"


   $.ajax({
       crossDomain: true,
            url: "http://localhost:8080/api/card/GetLinkcards/1",
            type: 'GET',
            headers: {"Authorization":  headertoken },
            contentType: 'application/json; charset=utf-8',
            success: function(result){
              vm.Usercard(result);
              },
              error: function(XMLHttpRequest, textStatus, errorThrown) {
                  alert("Status: " + textStatus);
                  alert("Error: " + errorThrown);
              }
            });


      }
           var init = function(opt) {
            option = opt || defaultOption;
            var username="username";
            token = getCookie(username);
            headertoken="Bearer " + token;
            createViewModel();
            ko.applyBindings(vm, option.form);
        };

        return {
            init: init,
            model: vm
        };

    }(jQuery || $)));
