"use strict";

(function () {
    angular.module("app")
        .controller("detailsItemController",
        ["$http", "$stateParams", DetailsCtrl]);

    function DetailsCtrl($http, $stateParams) {
        var vm = this;

        vm.getItems = function(){
            $http({
                method: 'GET',
                url: '/items/all'
            }).then(function successCallback(response) {
                var itemFilter  = response.data.filter(function( obj ) {
                    return obj.id == $stateParams.id;
                });
                vm.item = itemFilter[0];
            }, function errorCallback(response) {
                console.log(error);
            });
        };

        var init = function(){
            vm.getItems();
        };

        init();


    }
}());