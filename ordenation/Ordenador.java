package ordenation;

import java.util.ArrayList;
import java.util.Random;

import carro.Motor;
import carro.MotorStatus;

public class Ordenador {
	
	/*O método "ordenarMotoresPorTemperatura irá percorrer todo o ArrayList de "statusMotores" verificando através
	da temperatura se todos os dados do array estão ordenandos de forma crescente pela mesma temperatura. Se
	isso não estiver ocorrendo, o if do for interno será requisitados para dar início as mudanças necessárias, após 
	isso o if do for externo irá realizar a alteração de ordem no array com base no requisito atendido no if anterior, 
	sendo assim o for percorrerá todo o array até tudo estiver ordenado da maneira correta, conforme foi solicitado. 
	O método tem uma complexidade de algorítmos de O(2^N), pois se necessita navegar pela lista realizando a com-
	paração do atual elemento do for com o do que está uma posição a frente. A introdução de muitos dados pode le-
	var mais lento e consumir mais recursos computacionais.*/
public static void ordenarMotoresPorTemperatura(ArrayList<MotorStatus> statusMotores) {
    int n = statusMotores.size();
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (statusMotores.get(j).getTemperatura() < statusMotores.get(minIndex).getTemperatura()) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            MotorStatus temp = statusMotores.get(i);
            statusMotores.set(i, statusMotores.get(minIndex));
            statusMotores.set(minIndex, temp);
        	}
    	}
	}
}
