"use strict";

(function () {
    angular.module("app")
        .controller("itemController",
        ["$http", ItemCtrl]);

    function ItemCtrl($http) {
        var vm = this;

        vm.getItems = function(){
            $http({
                method: 'GET',
                url: '/items/all'
            }).then(function successCallback(response) {
                vm.items = response.data;
            }, function errorCallback(response) {
                console.log(error);
            });
        };

        vm.delete = function(itemId){
            $http({
                method: 'DELETE',
                url: '/items/delete/' + itemId
            }).then(function successCallback(response) {
                vm.items = _.without(vm.items, _.findWhere(vm.items, {id: itemId}));
            }, function errorCallback(error) {
                console.log(error);
            });

        };

        var init = function(){
            vm.getItems();
        };

        init();

    }
}());