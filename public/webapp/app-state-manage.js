"use strict";

(function () {

    angular.module('app').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("list");

        $stateProvider.state("list", {
            url: "/list",
            views: {
                "content": {
                    templateUrl: "features/item/item-index.html"
                }
            }
        }).state("add", {
                url: "/add",
                views: {
                    "content": {
                        templateUrl: "features/add-item/add-item-index.html"
                    }
                }
            })
            .state("amend", {
                url: "/amend/:id",
                views: {
                    "content": {
                        templateUrl: "features/amend-item/amend-item-index.html"
                    }
                }
            }).state("details", {
                url: "/details/:id",
                views: {
                    "content": {
                        templateUrl: "features/details/details-item-index.html"
                    }
                }
            })
    });
}());