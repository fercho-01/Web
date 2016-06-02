/**
 * 
 */
var app = angular.module('clientes',[]);
var servicioLista = "http://localhost:8080/Web/rest/Cliente/Obtener";
app.controller('listaClientes',function($scope,Clientes){
	Clientes.listaClientes().success(function(data){
		//$scope.clientes = data.clienteDtoWs;
		var json = data.clienteDtoWs;
		var check=false;
		$scope.clientes = [];
		angular.forEach(json, function(item) {
			if(item.nombre!=undefined){
				$scope.clientes.push(item);
				check=true;
			}else{
				check=false;
			}
		});
		if(!check){
			$scope.clientes.push(data.clienteDtoWs);
		}
	});
});

app.service('Clientes',function($http){
	this.listaClientes = function(){
		return $http({
			method:'GET',
			url:servicioLista
		});
	}
});