package Greedy.java;

import java.util.HashMap;

class Lemonade {
	public static void main(String[] args) {
		// Caso 1
		if(lemonadeChange(new int[] {5, 5, 5, 10, 20}) == true)
			System.out.println("Verdadeiro");
		else
			System.out.println("Falso");
		
		// Caso 2
		if(lemonadeChange(new int[] {5, 5, 10, 10, 20}) == true)
			System.out.println("Verdadeiro");
		else
			System.out.println("Falso");
	}
	
    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> myBills = new HashMap<>();
        myBills.put(5, 0);
        myBills.put(10, 0);
        myBills.put(20, 0);

        for (int bill : bills) {
            // Adiciona a nota recebida ao nosso controle
            myBills.put(bill, myBills.get(bill) + 1);

            int change = bill - 5;

            // Tentativas de dar o troco, começando com cédulas de maior valor
            int[] values = {20, 10, 5};
            for (int value : values) {
                while (change >= value && myBills.get(value) > 0) {
                    myBills.put(value, myBills.get(value) - 1);
                    change -= value;
                }
            }

            // Se após tentar dar o troco ainda resta valor, retorna false
            if (change > 0) {
                return false;
            }
        }

        // Se foi possível dar o troco em todos os casos, retorna true
        return true;
    }
}
