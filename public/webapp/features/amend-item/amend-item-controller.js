"use strict";

(function () {
    angular.module("app")
        .controller("amendItemController",
        ["$http", "$state", "$stateParams", AmendCtrl]);

    function AmendCtrl($http, $state, $stateParams) {
        var vm = this;

        vm.updateItem = function(item)
        {
            item.id = $stateParams.id;
            $http({
                method: 'POST',
                data: JSON.stringify(item),
                url: '/items/updateItem'
            }).then(function successCallback(response) {
                $state.go("list");
            }, function errorCallback(error) {
                console.log(error);

            });

        };


    }
}());