/**
 * Se crea una directiva persona
 * @author LUIS FERNANDO OROZCO
 */
angular.module('miAplicacion', []).directive('persona',function() {
			return {
				//E significa etiquea
				//A atributo
				//C clase
				//M comentario
				restrict : 'E',
				scope : {},		//espacio de variables
				replace : true, //Reemplaza la etiqueta por el retorno
				template : '<h1> {{nombre_completo}} </h1>',
				//elemento es la etiqueta que va a retornar
				//atributos son los de la directiva
				link : function(scope, elemento, atributos) {
					scope.nombre_completo = atributos.nombre + ' '+ atributos.apellido;
					elemento.bind('click', function() {
						alert('Hola, soy ' + scope.nombre_completo);
					});
				}
			};
		});