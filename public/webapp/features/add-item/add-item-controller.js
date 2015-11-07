"use strict";

(function () {
    angular.module("app")
        .controller("addItemController",
        ["$http", "$state", AddCtrl]);

    function AddCtrl($http, $state) {
        var vm = this;

        vm.addNewItem = function(item)
        {
            item.id = "0";
            $http({
                method: 'POST',
                data: JSON.stringify(item),
                url: '/items/insert'
            }).then(function successCallback(response) {
                $state.go("list");
            }, function errorCallback(error) {
                console.log(error);
            });

        };


    }
}());