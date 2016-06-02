/**
 * 
 */
var cuestionario = angular.module('cuestionario',[]);
cuestionario.controller('Controlador',['$scope',function($scope){
	$scope.respuestasValidas=0;
	$scope.preguntas=[{id:1,
		texto:'Pregunta1',
		respuestaValida:1,
		respuesta:null,
		estado:'',
		respuestas:[{id:1,texto:'opcion1'},
			{id:2,texto:'opcion2'},
			{id:3,texto:'opcion3'}]
		},
		{id:2,
			texto:'Pregunta2',
			respuestaValida:1,
			respuesta:null,
			estado:'',
			respuestas:[{id:1,texto:'opcion1'},
				{id:2,texto:'opcion2'},
				{id:3,texto:'opcion3'}]
			}];
	
	$scope.Validar = function(pregunta){
		alert("ok");
		 if(pregunta.respuesta==pregunta.respuestaValida){
			 $scope.respuestasValidas++;
			 pregunta.estado='ok';
			 
		 }else{
			 if(pregunta.estado=='ok' && $scope.respuestasValidas>0){
				 $scope.respuestasValidas--;
			 }
			 pregunta.estado="error";
		 }
	};
	
}]);