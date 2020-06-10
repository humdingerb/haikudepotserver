/*
 * Copyright 2014-2020, Andrew Lindesay
 * Distributed under the terms of the MIT License.
 */

angular.module('haikudepotserver').controller(
    'AboutController',
    [
        '$scope', '$log', '$location',
        'jsonRpc', 'constants', 'userState', 'runtimeInformation',
        'breadcrumbs', 'breadcrumbFactory', 'errorHandling',
        'messageSource',
        function(
            $scope, $log, $location,
            jsonRpc, constants, userState, runtimeInformation,
            breadcrumbs, breadcrumbFactory, errorHandling,
            messageSource) {

            breadcrumbs.mergeCompleteStack([
                breadcrumbFactory.createHome(),
                breadcrumbFactory.applyCurrentLocation(breadcrumbFactory.createAbout())
            ]);

            $scope.serverProjectVersion = '...';
            $scope.contributors = undefined;

            function refreshRuntimeInformation() {
                runtimeInformation.getRuntimeInformation().then(
                    function(result) {
                        $scope.serverProjectVersion = result.projectVersion;
                    }
                );
            }

            function refreshContributors() {

                function loadNaturalLanguageTitle(contributor) {
                    messageSource.get(
                        userState.naturalLanguageCode(),
                        contributor.naturalLanguageKey).then(
                        function (title) {
                            contributor.naturalLanguageTitle = title;
                        },
                        function () {
                            contributor.naturalLanguageTitle = '???';
                        }
                    );
                }

                function createContributorFromDto(dto) {
                    return {
                        name: dto.name,
                        naturalLanguageKey:
                            dto.naturalLanguageCode
                                ? "naturalLanguage." + dto.naturalLanguageCode
                                : undefined,
                        typeKey: "about.contributors.contributor.type." + dto.type.toLowerCase()
                    };
                }

                jsonRpc.call(constants.ENDPOINT_API_V1_MISCELLANEOUS, "getAllContributors", [{}])
                    .then(
                        function (result) {
                            $scope.contributors = _.sortBy(
                                _.map(
                                    result.contributors || [],
                                    function (dto) {
                                        var contributor = createContributorFromDto(dto);
                                        if (contributor.naturalLanguageKey) {
                                            loadNaturalLanguageTitle(contributor);
                                        }
                                        return contributor;
                                    }
                                ),
                                function (contributor) {
                                    return contributor.typeKey + "." + contributor.name;
                                });
                            $log.info('fetched contributors');
                            return $scope.contributors;
                        },
                        function (err) {
                            errorHandling.handleJsonRpcError(err);
                        }
                    );
            }

            refreshRuntimeInformation();
            refreshContributors();

        }
    ]
);